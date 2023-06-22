package UnitTests;

import Entities.Candidate;
import Entities.Gender;
import Entities.Party;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandidateTest {

    private Party party;

    @Before
    public void setup() {
        party = new Party("Party A");
    }

    @Test
    public void constructor_ValidParameters_ShouldCreateCandidate() {
        Candidate candidate = new Candidate(1, "Leonardo", 20, Gender.MALE, party);

        Assert.assertEquals(1, candidate.getId());
        Assert.assertEquals("Leonardo", candidate.getName());
        Assert.assertEquals(20, candidate.getAge());
        Assert.assertEquals(Gender.MALE, candidate.getGender());
        Assert.assertEquals(party, candidate.getParty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_NullName_ShouldThrowIllegalArgumentException() {
        new Candidate(1, null, 20, Gender.MALE, party);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_EmptyName_ShouldThrowIllegalArgumentException() {
        new Candidate(1, "", 20, Gender.MALE, party);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_AgeLessThan18_ShouldThrowIllegalArgumentException() {
        new Candidate(1, "Leonardo", 17, Gender.MALE, party);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_NullGender_ShouldThrowIllegalArgumentException() {
        new Candidate(1, "Leonardo", 20, null, party);
    }

    @Test
    public void setName_ValidName_ShouldUpdateName() {
        Candidate candidate = new Candidate(1, "Leonardo", 20, Gender.MALE, party);

        candidate.setName("Breno");

        Assert.assertEquals("Breno", candidate.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setName_NullName_ShouldThrowIllegalArgumentException() {
        Candidate candidate = new Candidate(1, "Leonardo", 20, Gender.MALE, party);

        candidate.setName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setName_EmptyName_ShouldThrowIllegalArgumentException() {
        Candidate candidate = new Candidate(1, "Leonardo", 20, Gender.MALE, party);

        candidate.setName("");
    }

    @Test
    public void setGender_ValidGender_ShouldUpdateGender() {
        Candidate candidate = new Candidate(1, "Leonardo", 20, Gender.MALE, party);

        candidate.setGender(Gender.FEMALE);

        Assert.assertEquals(Gender.FEMALE, candidate.getGender());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setGender_NullGender_ShouldThrowIllegalArgumentException() {
        Candidate candidate = new Candidate(1, "Leonardo", 20, Gender.MALE, party);

        candidate.setGender(null);
    }

    @Test
    public void setParty_ValidParty_ShouldUpdateParty() {
        Candidate candidate = new Candidate(1, "Leonardo", 20, Gender.MALE, party);
        Party newParty = new Party("Party B");

        candidate.setParty(newParty);

        Assert.assertEquals(newParty, candidate.getParty());
    }
}
