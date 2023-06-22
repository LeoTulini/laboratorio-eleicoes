package Entities;

import Comparators.AgeComparator;
import Comparators.VoteComparator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Verification {
    private final Map<Candidate, Integer> votesPerCandidate = new HashMap<>();
    private Candidate mostVoted;
    private Candidate leastVoted;
    private Candidate oldest;
    private Candidate youngest;
    private int validVotes;
    private int invalidVotes;
    private final Map<Candidate, String> averageVotesPerCandidate = new HashMap<>();
    private final Collection<Vote> votes;

    public Verification(Election election){
        this.votes = election.getReadonlyVotes();
        defineVerification();
        setVotesInfos();
    }

    public void defineVerification(){
        setVotesPerCandidate();
        setMostAndLeastVoted();
        setOldestAndYoungest();
    }

    private void setVotesPerCandidate(){
        List<Candidate> votedCandidates = this.votes
                .stream()
                .map(Vote::getCandidate)
                .toList();

        for (Candidate candidate: votedCandidates) {
            if (!this.votesPerCandidate.containsKey(candidate)){
                int frequency = Collections.frequency(votedCandidates, candidate);
                this.votesPerCandidate.put(candidate, frequency);
            }
        }
    }

    private void setMostAndLeastVoted() {
        List<Map.Entry<Candidate, Integer>> entries = new ArrayList<>(votesPerCandidate.entrySet().stream().toList());
        entries.sort(new VoteComparator());

        mostVoted = entries.get(0).getKey();
        leastVoted = entries.get(entries.size() - 1).getKey();
    }

    private void setOldestAndYoungest(){
        List<Candidate> candidates = new ArrayList<>(votesPerCandidate.keySet().stream().toList());
        candidates.sort(new AgeComparator());

        oldest = candidates.get(0);
        youngest = candidates.get(candidates.size() - 1);
    }

    private void setVotesInfos(){
        this.validVotes = this.votes.stream()
                .filter(Vote::isValid)
                .toList()
                .size();

        this.invalidVotes = this.votes.stream()
                .filter(vote -> !vote.isValid())
                .toList()
                .size();

        for (Map.Entry<Candidate, Integer> entry: this.votesPerCandidate.entrySet()) {
            if (!this.averageVotesPerCandidate.containsKey(entry.getKey())){
                String average = round(
                        (((double) entry.getValue() / this.validVotes * 100.00)), 2)
                        + "%";
                this.averageVotesPerCandidate.put(entry.getKey(), average);
            }
        }
    }

    public String getResults(){
        StringBuilder builder = new StringBuilder(getVotesPerCandidateInfo());
        builder.append("\r");
        builder.append("Candidato(a) mais votado(a): " + this.mostVoted.getName() + " (" +
                this.mostVoted.getParty().name() + ")")
        .append("\r")
        .append("Candidato(a) menos votado(a): " + this.leastVoted.getName() + " (" +
                this.leastVoted.getParty().name() + ")")
        .append("\r")
        .append("Candidato(a) mais jovem:" + this.youngest.getName())
        .append("\r")
        .append("Candidato(a) mais velho(a):" + this.oldest.getName())
        .append("\r")
        .append("Total de votos: " + this.invalidVotes + this.validVotes)
        .append("\r")
        .append("MÉDIAS:\r")
        .append(getAverageVotesPerCandidateInfo());

        return builder.toString();
    }

    private String getVotesPerCandidateInfo(){
        String result = "";

        for (Map.Entry<Candidate, Integer> entry: this.votesPerCandidate.entrySet()) {
            result = result.concat("Candidato(a): " + entry.getKey().getName() + " | " +
                    "Total de votos válidos: " + entry.getValue() + "\n");
        }

        return result;
    }

    private String getAverageVotesPerCandidateInfo(){
        String result = "";

        for (Map.Entry<Candidate, String> entry: this.averageVotesPerCandidate.entrySet()) {
            result = result.concat("Candidato(a): " + entry.getKey().getName() + " | " +
                    "Média de votação: " + entry.getValue() + "\n");
        }

        return result;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
