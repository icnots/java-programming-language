package election;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import election.candidate.Candidate;

public class ElectionTest{
    @Test
    public void noVotes(){
        Election election = new Election();

        assertEquals(Candidate.JACK, election.getWinner());
    }

    @ParameterizedTest(name = "{0} wins with {1} number of votes")
    @CsvSource(textBlock = """
        JACK, 3
        SAM, 15
        MAX, 999
    """)
    public void singleCandidate(Candidate selected, int votes){
        Election election = new Election();

        election.addVotes(selected, votes);

        assertEquals(selected, election.getWinner());
    }

    @ParameterizedTest(name = "Candidates {0} and {1} with same number of votes ({2})")
    @CsvSource(textBlock = """
        JACK, SAM, 3
        SAM, MAX, 15
        MAX, JILL, 999
        JILL, MAX, 999
    """)
    public void twoCandidatesSameVoteCount(Candidate cand1, Candidate cand2, int voteCount){
        Election election = new Election();

        election.addVotes(cand1, voteCount);
        election.addVotes(cand2, voteCount);

        Candidate winner = cand1.ordinal() < cand2.ordinal() ? cand1 : cand2;
        
        assertEquals(winner, election.getWinner());
    }

    @Test
    public void candidateVoteCount(){
        Election election = new Election();
        int[] votes = new int[]{1, 4, 3, 2};
        for (int i = 0; i < votes.length; i++){
            election.addVotes(Candidate.values()[i], votes[i]);
        }

        assertArrayEquals(Candidate.values(), election.getCandidatesWithMoreVotesThan(0));

        Candidate[] candidatesWithMoreVotesThan1 = new Candidate[]{
            Candidate.JILL,
            Candidate.SAM,
            Candidate.MAX
        };
        assertArrayEquals(candidatesWithMoreVotesThan1, election.getCandidatesWithMoreVotesThan(1));

        Candidate[] candidatesWithMoreVotesThan2 = new Candidate[]{
            Candidate.JILL,
            Candidate.SAM
        };
        assertArrayEquals(candidatesWithMoreVotesThan2, election.getCandidatesWithMoreVotesThan(2));
        
        Candidate[] candidatesWithMoreVotesThan3 = new Candidate[]{
            Candidate.JILL
        };
        assertArrayEquals(candidatesWithMoreVotesThan3, election.getCandidatesWithMoreVotesThan(3));
        
        Candidate[] candidatesWithMoreVotesThan4 = new Candidate[]{};
        assertArrayEquals(candidatesWithMoreVotesThan4, election.getCandidatesWithMoreVotesThan(4));
    }

    @ParameterizedTest(name = "Candidates with more than {0} votes are the specific ones")
    @CsvSource(textBlock = """
        0, 'JACK,JILL,SAM,MAX'
        1, 'JILL,SAM,MAX'
        2, 'JILL,SAM'
        3, 'JILL'
        4, ''
    """)
    public void candidateVoteCountAdvanced(int voteCount, String candidateNames){
        Election election = new Election();
        int[] votes = new int[]{1, 4, 3, 2};
        for (int i = 0; i < votes.length; i++){
            election.addVotes(Candidate.values()[i], votes[i]);
        }

        String[] names = candidateNames.split(",");
        
        Candidate[] candidates;
        if (0 == names[0].length()){
            candidates = new Candidate[0];
        }else{
            candidates = new Candidate[names.length];
            for (int i = 0; i < names.length; i++){
                candidates[i] = Candidate.valueOf(names[i]);
            }
        }

        assertArrayEquals(candidates, election.getCandidatesWithMoreVotesThan(voteCount));
    }
}