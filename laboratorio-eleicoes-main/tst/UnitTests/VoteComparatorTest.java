package UnitTests;

import Comparators.AgeComparator;
import Comparators.VoteComparator;
import Entities.Candidate;
import Entities.Gender;
import Entities.Party;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;

public class VoteComparatorTest {


    private VoteComparator voteComparator;
    private Candidate candidateOne;
    private Candidate candidateTwo;
    private Candidate candidateThree;

    @Before
    public void setup() {
        Party partyA = new Party("party A");
        voteComparator = new VoteComparator();
        candidateOne = new Candidate(1,"Leonardo", 20, Gender.MALE, partyA);
        candidateTwo = new Candidate(2,"Breno", 21, Gender.MALE, partyA);
        candidateThree = new Candidate(3,"Maria", 25, Gender.FEMALE, partyA);
    }

    @Test
    public void compare_CandidateOneHasHigherVoteCount_ReturnsNegative() {
        int voteCountOne = 10;
        int voteCountTwo = 5;

        Map.Entry<Candidate, Integer> candidateOneEntry = new AbstractMap.SimpleEntry<>(candidateOne, voteCountOne);
        Map.Entry<Candidate, Integer> candidateTwoEntry = new AbstractMap.SimpleEntry<>(candidateTwo, voteCountTwo);

        int result = voteComparator.compare(candidateOneEntry, candidateTwoEntry);

        assertEquals(-1, result);
    }

    @Test
    public void compare_CandidateTwoHasHigherVoteCount_ReturnsPositive() {
        int voteCountOne = 5;
        int voteCountTwo = 10;

        Map.Entry<Candidate, Integer> candidateOneEntry = new AbstractMap.SimpleEntry<>(candidateOne, voteCountOne);
        Map.Entry<Candidate, Integer> candidateTwoEntry = new AbstractMap.SimpleEntry<>(candidateTwo, voteCountTwo);

        int result = voteComparator.compare(candidateOneEntry, candidateTwoEntry);

        assertEquals(1, result);
    }

    @Test
    public void compare_CandidateVoteCountsAreEqual_ReturnsZero() {
        int voteCount = 5;

        Map.Entry<Candidate, Integer> candidateOneEntry = new AbstractMap.SimpleEntry<>(candidateOne, voteCount);
        Map.Entry<Candidate, Integer> candidateTwoEntry = new AbstractMap.SimpleEntry<>(candidateTwo, voteCount);

        int result = voteComparator.compare(candidateOneEntry, candidateTwoEntry);

        assertEquals(0, result);
    }
}
