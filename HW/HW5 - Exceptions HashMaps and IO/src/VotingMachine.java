import java.util.Scanner;

public class VotingMachine {
	// private Scanner scanner = new Scanner(System.in);

	private static I3VoteStrategy strat = new MostFirstVotesStrategy();
	private static I3VoteStrategy strat2 = new MostAgreeableStrategy();
	private static ElectionData e = new ElectionData(strat);
	private static ElectionData e2 = new ElectionData(strat2);
	private static Scanner text = new Scanner(System.in);
	private static int stratUsed = 0;

	public static void main(String[] args) throws AlreadyNominatedException, CandidateNotNominatedException {
		originalPrompt();
	}

	/**
	 * The entrypoint for the 'recursive' reading of console inputs
	 * 
	 * @throws AlreadyNominatedException
	 * @throws CandidateNotNominatedException
	 */
	private static void originalPrompt() throws AlreadyNominatedException, CandidateNotNominatedException {
		System.out.println("Do you want to [n]ominate someone, "
				+ "[v]ote for someone, "
				+ "change winner [s]trategy, "
				+ "see who [w]on, or [q]uit?");
		inputCommands(text.nextLine());
	}

	/**
	 * Method that is called 'recursively' to continue the voting algorithm.
	 * 
	 * @param in the line entered by the user in the console
	 * @throws AlreadyNominatedException
	 * @throws CandidateNotNominatedException
	 */
	private static void inputCommands(String in) throws AlreadyNominatedException, CandidateNotNominatedException {

		if (in.toLowerCase().startsWith("n")) {
			inputN();
		} else if (in.toLowerCase().startsWith("v")) {
			inputV();
		} else if (in.toLowerCase().startsWith("s")) {
			inputS();
		} else if (in.toLowerCase().startsWith("w")) {
			inputW();
		} else if (in.toLowerCase().startsWith("q")) {
			inputQ();
		} else {
			System.out.println("Choice not available, restarting. Try again:" + "\n");
			originalPrompt();
			inputCommands(text.nextLine());
		}
	}

	/**
	 * When the user wants to enter a name
	 * 
	 * @throws AlreadyNominatedException
	 * @throws CandidateNotNominatedException
	 */
	private static void inputN() throws AlreadyNominatedException, CandidateNotNominatedException {
		System.out.println("Enter a name:");
		String name = text.nextLine();
		try {
			e.nominateCandidate(name.toLowerCase());
		} catch (AlreadyNominatedException m) {
			System.out.println(m.getMessage());
			System.out.println("Try again? y/n");
			String decision = text.nextLine();
			if (decision.contains("y")) {
				inputN();
			}
		} finally {
			originalPrompt();
		}

	}

	/**
	 * When the user wants to vote
	 * 
	 * @throws AlreadyNominatedException
	 * @throws CandidateNotNominatedException
	 */
	private static void inputV() throws AlreadyNominatedException, CandidateNotNominatedException {
		System.out.println("Who is your first choice?");
		String first = text.nextLine();
		System.out.println("Who is your second choice?");
		String second = text.nextLine();
		System.out.println("Who is your third choice?");
		String third = text.nextLine();
		try {
			e.submitVote(first.toLowerCase(), second.toLowerCase(), third.toLowerCase());
		} catch (MoreThanOnceException m) {
			System.out.println(m.getMessage());
			System.out.println("Try again? y/n");
			String decision = text.nextLine();
			if (decision.contains("y")) {
				inputV();
			}
		} catch (CandidateNotNominatedException c) {
			System.out.println(c.getMessage());
			System.out.println("Try again? y/n");
			String decision = text.nextLine();
			if (decision.contains("y")) {
				inputV();
			}
		} finally {
			originalPrompt();
		}
	}

	/**
	 * When the user wants to set the strategy
	 * 
	 * @throws AlreadyNominatedException
	 * @throws CandidateNotNominatedException
	 */
	private static void inputS() throws AlreadyNominatedException, CandidateNotNominatedException {
		System.out.println("Which strategy would you like to use? "
				+ "Most [f]irst votes or most [a]greeable?");
		String decision = text.nextLine();
		if (decision.contains("a")) {
			e.setStrategy(strat2);
			stratUsed = 1;
		} else if (decision.contains("f")) {
			e.setStrategy(strat);
			stratUsed = 0;
		} else {
			System.out.println("Invalid strategy. Try again.\n");
			inputS();
		}
		originalPrompt();
	}

	/**
	 * When the user wants to check the winner
	 * 
	 * @throws AlreadyNominatedException
	 * @throws CandidateNotNominatedException
	 */
	private static void inputW() throws AlreadyNominatedException, CandidateNotNominatedException {
		if (!e.calculateWinner().isPresent()) {
			System.out.println("No clear winner under the current strategy.");
		} else if (stratUsed == 0) {
			System.out.println(e.calculateWinner().get());
		} else if (stratUsed == 1) {
			System.out.println(e2.calculateWinner().get());
		}
		originalPrompt();
	}

	/**
	 * When the user prompts to quit
	 */
	private static void inputQ() {
		System.out.println("Quitting...");
		// doesn't call back to prompt method, therefor quits.
	}
}
