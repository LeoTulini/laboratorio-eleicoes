package UnitTests;

import Entities.Candidate;
import Comparators.AgeComparator;
import Entities.Gender;
import Entities.Party;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgeComparatorTest {

    private AgeComparator ageComparator;
    private Candidate candidateOne;
    private Candidate candidateTwo;
    private Candidate candidateThree;

    @Before
    public void setup() {
        Party partyA = new Party("party A");
        ageComparator = new AgeComparator();
        candidateOne = new Candidate(1,"Leonardo", 20, Gender.MALE, partyA);
        candidateTwo = new Candidate(2,"Breno", 21, Gender.MALE, partyA);
        candidateThree = new Candidate(3,"Maria", 25, Gender.FEMALE, partyA);
    }

    @Test
    public void compare_FirstCandidateIsYounger_ShouldReturnNegative() {
        int result = ageComparator.compare(candidateOne, candidateTwo);
        Assert.assertFalse(result < 0);
    }

    @Test
    public void compare_FirstCandidateIsOlder_ShouldReturnPositive() {
        int result = ageComparator.compare(candidateTwo, candidateOne);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void compare_CandidatesHaveSameAge_ShouldReturnZero() {
        int result = ageComparator.compare(candidateOne, candidateThree);
        Assert.assertEquals(1, result);
    }
}
