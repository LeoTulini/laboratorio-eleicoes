package Entities;

import java.util.*;

public class Verification {
    private Map<Candidate, Integer> votesPerCandidate = new HashMap<>();
    private Candidate mostVoted;
    private Candidate leastVoted;
    private Candidate oldest;
    private Candidate youngest;
    private int validVotes;
    private int invalidVotes;
    private Map<Candidate, String> averageVotesPerCandidate = new HashMap<>();
    private Collection<Vote> votes;
    private Collection<Candidate> candidates;

    public Verification(Election election){
        this.candidates = election.getReadonlyCandidates();
        this.votes = election.getReadonlyVotes();
        defineVerification();
        setVotesInfos();
    }

    public void defineVerification(){
        setVotesPerCandidate();
        setMostVoted();
        setLeastVoted();
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

    private void setMostVoted() {
        int mostVotes = 0;

        for (Map.Entry<Candidate, Integer> entry: this.votesPerCandidate.entrySet()) {
            if(entry.getValue() > mostVotes){
                mostVotes = entry.getValue();
                this.mostVoted = entry.getKey();
            }
        }
    }

    private void setLeastVoted(){
        int leastVotes = 0;

        for (Map.Entry<Candidate, Integer> entry: this.votesPerCandidate.entrySet()) {
            if(entry.getValue() <= leastVotes || this.leastVoted == null){
                leastVotes = entry.getValue();
                this.leastVoted = entry.getKey();
            }
        }
    }

    private void setOldestAndYoungest(){
        int highestAge = 0;
        int lowestAge = 0;

        for (Map.Entry<Candidate, Integer> entry: this.votesPerCandidate.entrySet()) {
            if (entry.getKey().getAge() > highestAge){
                highestAge = entry.getKey().getAge();
                this.oldest = entry.getKey();
                continue;
            }

            if (entry.getKey().getAge() < lowestAge || this.youngest == null){
                highestAge = entry.getKey().getAge();
                this.youngest = entry.getKey();
            }
        }
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
                String average = ((entry.getValue() / (double) this.validVotes) * 100) + "%";
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
        String oi =  builder.toString();

        return oi;
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
}
