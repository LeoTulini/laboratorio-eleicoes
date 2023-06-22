package UnitTests;

import Entities.Candidate;
import Comparators.AgeComparator;
import Entities.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgeComparatorTest {

    private AgeComparator ageComparator;
    private Candidate candidateOne;
    private Candidate candidateTwo;

    @Before
    public void setup() {
        Party
        ageComparator = new AgeComparator();
        candidateOne = new Candidate(1,"Leonardo", 20, Gender.MALE, partyA);
        candidateTwo = new Candidate("Breno", 21);
    }

    @Test
    public void Compare_FirstCandidateIsYounger_ShouldReturnNegative() {
        int result = ageComparator.compare(candidateOne, candidateTwo);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void Compare_FirstCandidateIsOlder_ShouldReturnPositive() {
        int result = ageComparator.compare(candidateTwo, candidateOne);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void Compare_CandidatesHaveSameAge_ShouldReturnZero() {
        Candidate candidateThree = new Candidate("Joao", 25);
        int result = ageComparator.compare(candidateOne, candidateThree);
        Assert.assertEquals(0, result);
    }
}
