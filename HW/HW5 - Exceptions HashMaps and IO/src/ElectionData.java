import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ElectionData {
    private HashMap<String, Votes> nominees = new HashMap<String,Votes>();
    private I3VoteStrategy strat;

    /**
     * Constructor for ElectionData
     * @param strategy a class which implements I3VoteStrategy
     */
    public ElectionData(I3VoteStrategy strategy){
        this.strat = strategy;
    }

    /**
     * Changes the specified strategy
     * @param strategy a class which implements I3VoteStrategy
     */
    public void setStrategy(I3VoteStrategy strategy){
        this.strat = strategy;
    }

    /**
     * Provides a set of the currently stored candidates
     * @return a Set of Strings representing the currently stored candidates.
     */
    public Set<String> getCandidates(){
        return new HashSet<String>(nominees.keySet());
    }

    /**
     * Nominates a new candidate that can be seen with the method getCandidates()
     * @param person a string of a persons name you wish to nominate
     * @throws AlreadyNominatedException when the person has already been nominated
     */
    public void nominateCandidate(String person) throws AlreadyNominatedException {
        if(nominees.containsKey(person)){ //if the key exists, throw error
            throw new AlreadyNominatedException(person);
        } else { //if key doesn't exist, add a new candidate
            nominees.put(person, new Votes(0,0,0));
        }
    }

    /**
     * Accepts 3 strings, representing the name of the candidate you wish to vote for.
     * @param first your first vote
     * @param second your second vote
     * @param third your third vote
     * @throws CandidateNotNominatedException when one of the candidates is not nominated
     * @throws MoreThanOnceException when you vote for a candidate more than once
     */
    public void submitVote(String first, String second, String third) throws CandidateNotNominatedException, MoreThanOnceException {
        if(first.equals(second) || first.equals(third)){ throw new MoreThanOnceException(first); }
        if(second.equals(third)){ throw new MoreThanOnceException(second); }

        if(!nominees.containsKey(first))  { throw new CandidateNotNominatedException(first); }
        if(!nominees.containsKey(second)) { throw new CandidateNotNominatedException(second); }
        if(!nominees.containsKey(third))  { throw new CandidateNotNominatedException(third); }

        nominees.get(first).voteFirst();
        nominees.get(second).voteSecond();
        nominees.get(third).voteThird();

    }

    /**
     * Calculates the winner with the strategy passed in via the constructor or altered via .setStrategy()
     * @return an optional containing the winner if there is a valid one present, or an empty if there is no valid winner.
     */
    public Optional<String> calculateWinner(){
        return strat.calculateWinner(nominees);
    }




}
