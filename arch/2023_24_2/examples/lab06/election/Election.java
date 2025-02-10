package election;

import election.candidate.Candidate;

public class Election{
    private int[] voteCounts;

    public Election(){
        int length = Candidate.values().length;
        voteCounts = new int[length];
    }

    public void addVote(Candidate candidate){
        int index = candidate.ordinal();
        voteCounts[index] += 1;
    }

    public void addVotes(Candidate candidate, int n){
        for (int i = 0; i < n; i++){
            addVote(candidate);
        }
        /*
        int index = candidate.ordinal();
        voteCounts[index] += n;
        */
    }

    private int getCandidateCountWithMoreVotesThan(int value){
        int n = 0;
        for (int elem : voteCounts){
            if (elem > value){
                n++;
            }
        }
        return n;
    }

    public Candidate[] getCandidatesWithMoreVotesThan(int value){
        int numberOfCandidadatesWithMoreVotes = getCandidateCountWithMoreVotesThan(value);
        Candidate[] candidatesWithMoreVotes = new Candidate[numberOfCandidadatesWithMoreVotes];
        int counter = 0;
        for (int i = 0; i < voteCounts.length; i++){
            if (voteCounts[i] > value){
                candidatesWithMoreVotes[counter] = Candidate.values()[i];
                counter++;
            }
        }
        return candidatesWithMoreVotes;
    }

    private int getWinningIdx(){
        int candidateIndex = 0;
        for (int i = 1; i < Candidate.values().length; i++){
            if (voteCounts[candidateIndex] < voteCounts[i]){
                candidateIndex = i;
            }
        }
        return candidateIndex;
    }

    public Candidate getWinner(){
        return Candidate.values()[getWinningIdx()];
    }
}