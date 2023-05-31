import Entities.*;
import Exceptions.VoteException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws VoteException {
        Party[] parties = createParties();
        ArrayList<Candidate> candidates = createCandidates(parties);

        Election election = new Election(candidates);

        try {
            election.addVote(new Vote(candidates.get(0)));
            election.addVote(new Vote(candidates.get(0)));
            election.addVote(new Vote(candidates.get(0)));
            election.addVote(new Vote(candidates.get(0)));
            election.addVote(new Vote(candidates.get(1)));
            election.addVote(new Vote(candidates.get(1)));
            election.addVote(new Vote(candidates.get(2)));
            election.addVote(new Vote(candidates.get(2)));
            election.addVote(new Vote(candidates.get(2)));
        } catch(VoteException voteException) {
            System.out.println("Oh no!");
        }

        Verification verification = new Verification(election);
        String results = verification.getResults();
        System.out.println(results);
    }

    private static Party[] createParties(){
        Party naturers = new Party("Naturers");
        Party youtubersForLife = new Party("Youtubers4Life");
        Party sapKillers = new Party("SAP_Killers");

        return new Party[]{naturers, youtubersForLife, sapKillers};
    }
    private static ArrayList<Candidate> createCandidates(Party[] parties) {
        ArrayList<Candidate> candidates = new ArrayList<>();

        Candidate candidate0 = new Candidate(1,"July", 22, Gender.FEMALE, parties[0]);
        Candidate candidate1 = new Candidate(2, "Johnzinho", 42, Gender.GENDERQUEER, parties[0]);
        Candidate candidate2 = new Candidate(3,"Gislaine", 74, Gender.PANGENDER, parties[1]);
        Candidate candidate3 = new Candidate(4,"Hob", 79, Gender.PANGENDER, parties[1]);
        Candidate candidate4 = new Candidate(5,"Andressa", 52, Gender.GENDER_NEUTRAL, parties[2]);
        Candidate candidate5 = new Candidate(6,"Louie Vitao", 32, Gender.TWO_SPIRIT, parties[2]);

        candidates.add(candidate0);
        candidates.add(candidate1);
        candidates.add(candidate2);
        candidates.add(candidate3);
        candidates.add(candidate4);
        candidates.add(candidate5);

        return candidates;
    }
}