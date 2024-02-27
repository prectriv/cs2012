import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MostFirstVotesStrategy implements I3VoteStrategy {

    /**
     * Calculates the winner based on which candidate has the most first votes
     * @param votes a HashMap containing candidate names as keys and Votes objects for the value
     * @return an optional that contains a string if there is a valid winner, or empty if there is not.
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        int totalVotes = 0;

        for(Map.Entry<String, Votes> i : votes.entrySet()) {
            totalVotes += i.getValue().getFirstVotes();
        }

        String currentBestCandidate = "";
        int currentMostVotes = 0;

        for(Map.Entry<String, Votes> i : votes.entrySet()) {
            int cv = i.getValue().getFirstVotes();
            if (cv > currentMostVotes){
                if(cv > (totalVotes / 2)){
                    currentMostVotes = cv;
                    currentBestCandidate = i.getKey();
                }
            }
        }

        return currentBestCandidate.equals("") ? Optional.empty() : Optional.of(currentBestCandidate);
    }
}
