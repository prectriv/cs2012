import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;

import org.junit.Test;

public class Examples {
    Votes v1 = new Votes(1, 2, 3);
    Votes v2 = new Votes(4, 5, 6);
    Votes v3 = new Votes(7, 8, 9);
    HashMap<String, Votes> map = new HashMap<String, Votes>();

    @Test
    public void mostFirstVotesTest()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData e = new ElectionData(new MostFirstVotesStrategy());
        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.submitVote("Winner", "Middle", "Loser");
        assertEquals(e.calculateWinner().get(), "Winner");
    }

    @Test(expected = AlreadyNominatedException.class)
    public void buggyTest1() throws CandidateNotNominatedException, MoreThanOnceException, AlreadyNominatedException {
        ElectionData e = new ElectionData(new MostFirstVotesStrategy());
        e.nominateCandidate("Winner");
        e.nominateCandidate("Winner");
        e.nominateCandidate("Loser");
        e.nominateCandidate("Middle");
        e.submitVote("Winner", "Middle", "Loser");
    }

    @Test(expected = MoreThanOnceException.class)
    public void buggyTest2() throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData e = new ElectionData(new MostFirstVotesStrategy());
        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.submitVote("Winner", "Winner", "Loser");
    }

    @Test(expected = CandidateNotNominatedException.class)
    public void buggyTest3() throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData e = new ElectionData(new MostFirstVotesStrategy());
        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.submitVote("Winner", "Participant", "Loser");
    }

    @Test
    public void buggyTest4() throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData e = new ElectionData(new MostFirstVotesStrategy());
        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.nominateCandidate("Participant");
        e.submitVote("Winner", "Middle", "Loser");
        e.submitVote("Winner", "Middle", "Participant");
        e.submitVote("Loser", "Middle", "Winner");
        e.submitVote("Loser", "Middle", "Winner");
        e.submitVote("Participant", "Middle", "Loser");
        e.submitVote("Participant", "Middle", "Loser");
        assertEquals(e.calculateWinner(), Optional.empty());
    }

    @Test
    public void getCandidatesTest() throws AlreadyNominatedException {
        ElectionData e = new ElectionData(new MostAgreeableStrategy());
        HashSet<String> set = new HashSet<String>();
        set.add("Winner");
        set.add("Loser");
        set.add("Middle");
        set.add("Participant");
        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.nominateCandidate("Participant");
        assertEquals(e.getCandidates(), set);
    }

    @Test
    public void getCandidatesTest2() throws AlreadyNominatedException {
        ElectionData e = new ElectionData(new MostFirstVotesStrategy());
        HashSet<String> set = new HashSet<String>();
        set.add("Winner");
        set.add("Loser");
        set.add("Middle");
        set.add("Participant");
        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.nominateCandidate("Participant");
        assertEquals(e.getCandidates(), set);
    }

    @Test
    public void mostAgreeableTest()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData e = new ElectionData(new MostAgreeableStrategy());
        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.nominateCandidate("Participant");
        e.submitVote("Winner", "Middle", "Loser");
        e.submitVote("Participant", "Middle", "Winner");
        assertEquals(e.calculateWinner().get(), "Middle");
    }

    @Test
    public void changeGetCandidatesTest()
            throws AlreadyNominatedException, MoreThanOnceException, CandidateNotNominatedException {
        ElectionData e = new ElectionData(new MostAgreeableStrategy());
        e.setStrategy(new MostFirstVotesStrategy());

        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.submitVote("Winner", "Middle", "Loser");
        assertEquals(e.calculateWinner().get(), "Winner");
    }

    @Test
    public void changeMostAgreeableTest()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData e = new ElectionData(new MostFirstVotesStrategy());
        e.setStrategy(new MostAgreeableStrategy());

        e.nominateCandidate("Winner");
        e.nominateCandidate("Middle");
        e.nominateCandidate("Loser");
        e.nominateCandidate("Participant");
        e.submitVote("Winner", "Middle", "Loser");
        e.submitVote("Participant", "Middle", "Winner");
        assertEquals(e.calculateWinner().get(), "Middle");
    }

    @Test
    public void notNominatedGetterTest() {
        CandidateNotNominatedException c = new CandidateNotNominatedException("Joe");
        assertEquals(c.getCandidate(), "Joe");
    }

}
