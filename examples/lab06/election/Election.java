package election;

import election.candidate.Candidate;

public class Election{
    private int[] voteCounts;

    public Election(){
        voteCounts = new int[Candidate.values().length];
    }

    public void addVote(Candidate candidate){
        voteCounts[candidate.ordinal()] += 1;
    }

    public void addVotes(Candidate candidate, int n){
        voteCounts[candidate.ordinal()] += n;
    }

    private int getCandidateCountWithMoreVotesThan(int n){
        int counter = 0;
        for (Candidate candidate : Candidate.values()){
            if (voteCounts[candidate.ordinal()] > n){
                counter += 1;
            }
        }
        return counter;
    }

    public Candidate[] getCandidatesWithMoreVotesThan(int n){
        Candidate[] candidates = new Candidate[getCandidateCountWithMoreVotesThan(n)];
        int counter = 0;
        for (Candidate candidate : Candidate.values()){
            if (voteCounts[candidate.ordinal()] > n){
                candidates[counter] = candidate;
                counter += 1;
            }
        }
        return candidates;
    }

    private int getWinningIdx(){
        int id = 0;
        int maxVoteCount = voteCounts[id];
        Candidate[] candidates = Candidate.values();
        int candidateLength = candidates.length;
        for (int i = 0; i < candidateLength; i++){
            if (maxVoteCount < voteCounts[i]){
                id = i;
                maxVoteCount = voteCounts[id];
            }
        }
        return id;
    }

    public Candidate getWinner(){
        return Candidate.values()[getWinningIdx()];
    }
}