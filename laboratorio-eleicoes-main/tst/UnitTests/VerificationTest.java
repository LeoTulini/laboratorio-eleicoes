package UnitTests;

import Entities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class VerificationTest {

    private List<Vote> votes;
    private Verification verification;

    @Before
    public void setup() {
        votes = new ArrayList<>();
        Party partyA = new Party("Party A");
        Party partyB = new Party("Party B");

        Candidate candidate1 = new Candidate(1, "Leonardo", 20, Candidate.Gender.MALE, partyA);
        Candidate candidate2 = new Candidate(2, "Bruna", 25, Candidate.Gender.FEMALE, partyA);

        votes.add(new Vote(candidate1, true));
        votes.add(new Vote(candidate2, true));
        votes.add(new Vote(candidate1, true));
        votes.add(new Vote(candidate1, true));

        Election election = new Election(votes);
        verification = new Verification(election);
    }

    @Test
    public void DefineVerification_ValidVotes_ShouldSetVotesPerCandidate() {
        Map<Candidate, Integer> votesPerCandidate = verification.getVotesPerCandidate();

        Assert.assertEquals(2, votesPerCandidate.size());
        Assert.assertEquals(3, votesPerCandidate.get(new Candidate(1, "Leonardo", 20, Candidate.Gender.MALE, null)).intValue());
        Assert.assertEquals(1, votesPerCandidate.get(new Candidate(2, "Bruna", 25, Candidate.Gender.FEMALE, null)).intValue());
    }

    @Test
    public void DefineVerification_ValidVotes_ShouldSetMostAndLeastVoted() {
        Candidate mostVoted = verification.getMostVoted();
        Candidate leastVoted = verification.getLeastVoted();

        Assert.assertEquals(new Candidate(1, "Leonardo", 20, Candidate.Gender.MALE, null), mostVoted);
        Assert.assertEquals(new Candidate(2, "Bruna", 25, Candidate.Gender.FEMALE, null), leastVoted);
    }

    @Test
    public void DefineVerification_ValidVotes_ShouldSetOldestAndYoungest() {
        Candidate oldest = verification.getOldest();
        Candidate youngest = verification.getYoungest();

        Assert.assertEquals(new Candidate(2, "Bruna", 25, Candidate.Gender.FEMALE, null), oldest);
        Assert.assertEquals(new Candidate(1, "Leonardo", 20, Candidate.Gender.MALE, null), youngest);
    }

    @Test
    public void GetResults_ValidVotes_ShouldReturnCorrectResults() {
        String expectedResults = "Candidato(a): Leonardo | Total de votos válidos: 3\n" +
                "Candidato(a): Bruna | Total de votos válidos: 1\n" +
                "\r" +
                "Candidato(a) mais votado(a): Leonardo (Party A)\r" +
                "Candidato(a) menos votado(a): Bruna (Party A)\r" +
                "Candidato(a) mais jovem: Leonardo\r" +
                "Candidato(a) mais velho(a): Bruna\r" +
                "Total de votos: 12\r" +
                "MÉDIAS:\r" +
                "Candid";}}
