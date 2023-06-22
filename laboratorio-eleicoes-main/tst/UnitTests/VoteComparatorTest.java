package UnitTests;

import Entities.Candidate;
import Comparators.VoteComparator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class VoteComparatorTest {

    private VoteComparator voteComparator;
    private Map.Entry<Candidate, Integer> candidateOneEntry;
    private Map.Entry<Candidate, Integer> candidateTwoEntry;

    @Before
    public void setup() {
        voteComparator = new VoteComparator();
        Candidate candidateOne = new Candidate("Leonardo");
        Candidate candidateTwo = new Candidate("Breno");
        candidateOneEntry = createEntry(candidateOne, 10);
        candidateTwoEntry = createEntry(candidateTwo, 15);
    }

    @Test
    public void Compare_FirstCandidateHasMoreVotes_ShouldReturnNegative() {
        int result = voteComparator.compare(candidateOneEntry, candidateTwoEntry);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void Compare_FirstCandidateHasLessVotes_ShouldReturnPositive() {
        int result = voteComparator.compare(candidateTwoEntry, candidateOneEntry);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void Compare_CandidatesHaveSameNumberOfVotes_ShouldReturnZero() {
        Map.Entry<Candidate, Integer> candidateThreeEntry = createEntry(new Candidate("Joao"), 25);
        int result = voteComparator.compare(candidateTwoEntry, candidateThreeEntry);
        Assert.assertEquals(0, result);
    }
}
