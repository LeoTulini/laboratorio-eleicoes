package Comparators;

import Entities.Candidate;
import java.util.Comparator;
import java.util.Map;

public class VoteComparator implements Comparator<Map.Entry<Candidate, Integer>> {
    @Override
    public int compare(Map.Entry<Candidate, Integer> candidateOneEntry,
                       Map.Entry<Candidate, Integer> candidateTwoEntry) {
        return Integer.compare(candidateTwoEntry.getValue(), candidateOneEntry.getValue());
    }
}
