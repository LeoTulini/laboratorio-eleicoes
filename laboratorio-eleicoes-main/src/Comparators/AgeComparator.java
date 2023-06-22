package Comparators;

import Entities.Candidate;
import java.util.Comparator;

public class AgeComparator implements Comparator<Candidate> {

    @Override
    public int compare(Candidate candidateOne, Candidate candidateTwo) {
        return Integer.compare(candidateTwo.getAge(), candidateOne.getAge());
    }
}
