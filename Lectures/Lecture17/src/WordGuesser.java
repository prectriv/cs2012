import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class WordGuesser {

	private IWords wordGenerator;
	private String currentWord;
	private String[] currentGuess;
	private int guesses = 5;
	private Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) {
		try {
			WordGuesser wg = new WordGuesser(new AnimalWords());
			wg.play();
		} catch (IOException e) {
			System.out.println("where the heck the file?");
		}


	}

	public WordGuesser(IWords wordGenerator) {
		this.wordGenerator = wordGenerator;
		this.currentWord = wordGenerator.randomWord().toLowerCase();
		this.clearGuess();
	}

	public void play() {
		boolean keepPlaying = true;
//        String input = scanner.nextLine();
//        System.out.println(input);

		while (keepPlaying) {

			// PRINT THE CURRENT GUESS
			System.out.print("Guess: ");
			for (String letterGuess : this.currentGuess) {
				System.out.print(letterGuess + " ");
			}
			System.out.print("\n");
			System.out.flush();


			// PRINT THE NUMBER OF GUESSES LEFT
			System.out.printf("Number of guesses left: %d\n", this.guesses);
			// ASK THE USER IF THEY WANT TO GUESS THE WORD OR GUESS A LETTER OR QUIT
			System.out.println("Do you want to guess a [l]etter, a [w]ord, or [q]uit?");

			// TAKE THE INPUT
			String input = scanner.nextLine().toLowerCase().trim();
			// HANDLE EACH CASE
			if (input.startsWith("l")) { // guess a letter
				//Prompt them to guess a letter
				System.out.println("Guess a letter");
				//take the letter
				String letter = scanner.nextLine().toLowerCase().trim().substring(0, 1);
				//check if the current word contains the letter
				if (this.currentWord.contains(letter)) {
					// if it's in the word, then replace the spots in the array with the letter
					for (int i = 0; i < this.currentWord.length(); i++) {
						// character at i is equal to letter
						if (String.valueOf(this.currentWord.charAt(i)).equals(letter)) {
							this.currentGuess[i] = letter;
						}
					}
				} else {
					// if it isn't: print that the guess is wrong, decrement the number of guess
					System.out.println("Your guess was wrong");
					this.guesses--;
				}

			} else if (input.startsWith("w")) { //guess a word
				//Prompt them to guess a word
				System.out.println("Guess a word");
				//take the word
				String word = scanner.nextLine().toLowerCase().trim();
				// check if word is equal to the currentWord
				if (this.currentWord.equals(word)) {
					//if it is: They won
					System.out.println("You won!");
					keepPlaying = false;
				} else {
					//if it isn't: decrement the number of guesses, keep playing
					this.guesses--;
				}
			} else { //want to quit
				keepPlaying = false;
				System.out.println("Thanks for playing!");
			}

			//If number of guesses is 0, you lose!
			if (this.guesses == 0) {
				System.out.println("You lose!");
				System.out.println("The word was: " + this.currentWord);
				keepPlaying = false;
			}

		}


	}

	public void clearGuess() {
		this.currentGuess = new String[this.currentWord.length()];
		for (int i = 0; i < this.currentGuess.length; i++) {
			this.currentGuess[i] = "_";
		}

		this.guesses = 10;
	}


	private HashSet<String> wordsGuessed = new HashSet<String>();

	/**
	 * Clean up user input and throw an exception in case the word is malformed for the game
	 *
	 * @param word the word the user is guessing before cleanup
	 * @return the word the user is guessing after cleanup
	 * @throws WordAlreadyGuessedException if the word has already been guessed
	 * @throws BlankWordException          if the word is just whitespace characters  ("" after trim)
	 * @throws WordContainsSpaceException  if the word contains a whitespace character in the middle somewhere
	 */
	private String processWord(String word) throws BlankWordException, WordAlreadyGuessedException, WordContainsSpaceException
	{
		String wordCleaned = word.toLowerCase().trim();
		if (wordCleaned.equals("")) {
			throw new BlankWordException();
		}
		if (wordCleaned.contains(" ")) {
			throw new WordContainsSpaceException(wordCleaned);
		}
		if (wordsGuessed.contains(wordCleaned)){
			throw new WordAlreadyGuessedException(wordCleaned);
		}

		this.wordsGuessed.add(wordCleaned);
		return wordCleaned;
	}

	/**
	 * Prompts the user to enter a word, handles any Exceptions for malformed words
	 *
	 * @return the word the user wants to guess
	 */
	private String promptWord() {
		System.out.println("Guess a word");
		String word = null;
		while (word == null) {
			try{
			word = this.processWord(scanner.nextLine());

			} catch(WordAlreadyGuessedException e ){
				System.out.println(e.getMessage());
				this.guesses--; // punish them for guessing the same word twice
				System.out.println("Please guess a different word");
			} catch(BlankWordException e ){
				System.out.println(e.getMessage()); // don't punish for hitting enter too soon
				System.out.println("Please guess again.");
			} catch(WordContainsSpaceException e ){
				System.out.println(e.getMessage());
				System.out.println("Please enter both words separately");
			}
		}
		return word;
	}


	public class WordAlreadyGuessedException extends Exception {

		public WordAlreadyGuessedException(String word) {
			super(word + " already guessed.");
		}
	}


	public class BlankWordException extends Exception {
	}


	public class WordContainsSpaceException extends Exception {

		public WordContainsSpaceException(String word) {
			super(word + " contains space character");
		}
	}
}
