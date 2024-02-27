import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MostAgreeableStrategy implements I3VoteStrategy {

    /**
     * Calculates the winner based on which candidate has the most votes in any category
     * @param votes a HashMap containing candidate names as keys and Votes objects for the value
     * @return an optional that contains a string if there is a valid winner, or empty if there is not.
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        String currentBestCandidate = "";
        int currentMostVotes = 0;

        for(Map.Entry<String, Votes> i : votes.entrySet()) {
            //maximum value of the 3 vote types.
            int cv = Math.max(i.getValue().getFirstVotes(), Math.max(i.getValue().getSecondVotes(), i.getValue().getThirdVotes()));
            if (cv > currentMostVotes){
                currentMostVotes = cv;
                currentBestCandidate = i.getKey();
                }
            }

        return currentBestCandidate.equals("") ? Optional.empty() : Optional.of(currentBestCandidate);
    }
}
