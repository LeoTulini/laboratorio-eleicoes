package Entities;
import Exceptions.VoteException;

import java.util.*;
import java.util.stream.Collectors;

public class Election {
    private final ArrayList<Candidate> candidates;
    private ArrayList<Vote> votes = new ArrayList<>();

    public Election(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public Collection<Vote> getReadonlyVotes() {
        return Collections.unmodifiableCollection(this.votes);
    }

    public Collection<Candidate> getReadonlyCandidates() {
        return Collections.unmodifiableCollection(this.candidates);
    }

    public void addVote(Vote vote) throws VoteException {
        if (!vote.isValid()){
            throw new VoteException("");
        }

        this.votes.add(vote);
    }
}
