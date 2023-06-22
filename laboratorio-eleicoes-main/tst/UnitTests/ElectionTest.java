package UnitTests;

import Entities.Candidate;
import Entities.Election;
import Entities.Gender;
import Entities.Party;
import Entities.Vote;
import Exceptions.VoteException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ElectionTest {

    private Election election;
    private Candidate candidate1;
    private Candidate candidate2;

    @Before
    public void setup() {
        candidate = new Candidate(1, "Leonardo", 20, Gender.MALE, new Party("Party A"));

        election = new Election(candidates);
    }

    @Test
    public void AddVote_ValidVote_ShouldAddVote() throws VoteException {
        Vote vote = new Vote(candidate);

        election.addVote(vote);
        Collection<Vote> votes = election.getReadonlyVotes();

        Assert.assertEquals(1, votes.size());
        Assert.assertTrue(votes.contains(vote));
    }

    @Test(expected = VoteException.class)
    public void AddVote_InvalidVote_ShouldThrowVoteException() throws VoteException {
        Vote invalidVote = new Vote(null);

        election.addVote(invalidVote);
    }
}
