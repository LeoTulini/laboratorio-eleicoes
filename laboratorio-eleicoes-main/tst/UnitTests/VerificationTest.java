package UnitTests;

import Entities.*;
import Exceptions.VoteException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class VerificationTest {

    private Election election;
    private Vote voteOne;
    private Vote voteTwo;
    private Vote voteThree;
    private Vote voteFour;
    private Vote voteFive;
    private Vote voteSix;
    private Vote voteSeven;
    private Verification verification;
    private ArrayList<Candidate> candidates;
    private Candidate candidateOne;
    private Candidate candidateTwo;

    @Before
    public void setup() throws VoteException {
        Party partyA = new Party("Party A");
        Party partyB = new Party("Party B");
        candidateOne = new Candidate(1, "Leonardo", 20, Gender.MALE, partyA);
        candidateTwo = new Candidate(2, "Breno", 21, Gender.MALE, partyB);
        candidates = new ArrayList<>(Arrays.asList(candidateOne, candidateTwo));
        election = new Election(candidates);

        voteOne = new Vote(candidateOne);
        voteTwo = new Vote(candidateTwo);
        voteThree = new Vote(candidateTwo);
        voteFour = new Vote(candidateOne);
        voteFive = new Vote(candidateTwo);
        voteSix = new Vote(candidateOne);
        voteSeven = new Vote(candidateOne);

        election.addVote(voteOne);
        election.addVote(voteTwo);
        election.addVote(voteThree);
        election.addVote(voteFour);
        election.addVote(voteFive);
        election.addVote(voteSix);
        election.addVote(voteSeven);

        verification = new Verification(election);
    }

    @Test
    public void defineVerification_SetsVotesPerCandidate() {
        verification.defineVerification();
        Collection<Candidate> candidates = verification.getVotesPerCandidate().keySet();

        assertEquals(2, candidates.size());
        assertTrue(candidates.contains(candidateOne));
        assertTrue(candidates.contains(candidateTwo));
    }

    @Test
    public void defineVerification_SetsMostAndLeastVoted() {
        verification.defineVerification();
        Candidate mostVoted = verification.getMostVoted();
        Candidate leastVoted = verification.getLeastVoted();

        assertEquals(candidateOne, mostVoted);
        assertEquals(candidateTwo, leastVoted);
    }

    @Test
    public void defineVerification_SetsOldestAndYoungest() {
        verification = new Verification(election);
        verification.defineVerification();
        Candidate oldest = verification.getOldest();
        Candidate youngest = verification.getYoungest();

        assertEquals(candidateTwo, oldest);
        assertEquals(candidateOne, youngest);
    }

    @Test
    public void setVotesInfos_SetsValidVotesAndInvalidVotes() {
        verification.setVotesInfos();
        int validVotes = verification.getValidVotes();
        int invalidVotes = verification.getInvalidVotes();

        assertEquals(7, validVotes);
        assertEquals(0, invalidVotes);
    }
}
