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

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ElectionTest {

    private Election election;
    private Candidate candidateOne;
    private Candidate candidateTwo;
    private Candidate candidateThree;

    @Before
    public void setup() {
        Party partyA = new Party("party A");
        candidateOne = new Candidate(1,"Leonardo", 20, Gender.MALE, partyA);
        candidateTwo = new Candidate(2,"Breno", 21, Gender.MALE, partyA);
        candidateThree = new Candidate(3,"Maria", 25, Gender.FEMALE, partyA);

        ArrayList<Candidate> candidates = new ArrayList<>(Arrays.asList(candidateOne, candidateTwo, candidateThree));

        election = new Election(candidates);
    }

    @Test
    public void addVote_ValidVote_ShouldAddVote() throws VoteException {
        Vote vote = new Vote(candidateOne);

        election.addVote(vote);
        Collection<Vote> votes = election.getReadonlyVotes();

        assertEquals(1, votes.size());
        assertTrue(votes.contains(vote));
    }

    @Test
    public void getCandidates_ReturnsUnmodifiableList() {
        List<Candidate> returnedCandidates = election.getCandidates();
        try {
            returnedCandidates.add(new Candidate(4, "Joao", 18, Gender.MALE, new Party("Party B")));
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }

        assertEquals(4, returnedCandidates.size());
        assertTrue(returnedCandidates.contains(candidateOne));
        assertTrue(returnedCandidates.contains(candidateTwo));
    }

    @Test
    public void getReadonlyVotes_ReturnsUnmodifiableCollection() throws VoteException {
        Vote vote = new Vote(candidateOne);
        election.addVote(vote);

        Collection<Vote> returnedVotes = election.getReadonlyVotes();
        try {
            returnedVotes.add(new Vote(candidateOne));
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }

        assertEquals(1, returnedVotes.size());
        assertTrue(returnedVotes.contains(vote));
    }
}
