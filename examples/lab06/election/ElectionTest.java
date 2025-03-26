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

public class ElectionTest {
    @Test
    public void noVotes() {
        Election election = new Election();

        assertEquals(Candidate.values()[0], election.getWinner());
    }


    @ParameterizedTest(name = "{0} has won with {1} votes")
    @CsvSource(textBlock = """
        JACK, 10
        JILL, 10
        SAM, 20
        MAX, 100
    """)
    @DisableIfHasBadStructure
    public void singleCandidate(Candidate candidate, int voteNumber) {
        Election election = new Election();

        election.addVotes(candidate, voteNumber);

        assertEquals(candidate, election.getWinner());
    }

    @ParameterizedTest(name = "{0} and {1} with {2} votes")
    @CsvSource(textBlock = """
        JACK, JILL, 10
        JILL, SAM, 20
        SAM, JACK, 30
        MAX, JACK, 40
        SAM, MAX, 50
        JILL, MAX, 60
    """)
    @DisableIfHasBadStructure
    public void twoCandidatesSameVoteCount(Candidate candidate1, Candidate candidate2, int votes) {
        Election election1 = new Election();
        Election election2 = new Election();

        election1.addVotes(candidate1, votes);
        election1.addVotes(candidate2, votes);

        election2.addVotes(candidate2, votes);
        election2.addVotes(candidate1, votes);

        Candidate expected = candidate1.ordinal() < candidate2.ordinal() ? candidate1 : candidate2;

        assertEquals(expected, election1.getWinner());
        assertEquals(expected, election2.getWinner());
    }

    @Test
    @DisableIfHasBadStructure
    public void candidateVoteCount() {
        Election election = new Election();

        election.addVotes(Candidate.JACK, 1);
        election.addVotes(Candidate.JILL, 4);
        election.addVotes(Candidate.SAM, 3);
        election.addVotes(Candidate.MAX, 2);

        assertArrayEquals(Candidate.values(), election.getCandidatesWithMoreVotesThan(0));
        assertArrayEquals(
            new Candidate[]{
                Candidate.JILL,
                Candidate.SAM,
                Candidate.MAX
            },
            election.getCandidatesWithMoreVotesThan(1)
        );
        assertArrayEquals(
            new Candidate[]{
                Candidate.JILL,
                Candidate.SAM
            },
            election.getCandidatesWithMoreVotesThan(2)
        );
        assertArrayEquals(
            new Candidate[]{
                Candidate.JILL
            },
            election.getCandidatesWithMoreVotesThan(3)
        );
        assertArrayEquals(
            new Candidate[0],
            election.getCandidatesWithMoreVotesThan(4)
        );
    }

    @ParameterizedTest(name = "higher than {0} votes are {1}")
    @CsvSource(textBlock = """
        0, 'JACK,JILL,SAM,MAX'
        1, 'JILL,SAM,MAX'
        2, 'JILL,SAM'
        3, 'JILL'
        4, ''
    """)
    @DisableIfHasBadStructure
    public void candidateVoteCountAdvanced(int limit, String param) {
        Election election = new Election();

        election.addVotes(Candidate.JACK, 1);
        election.addVotes(Candidate.JILL, 4);
        election.addVotes(Candidate.SAM, 3);
        election.addVotes(Candidate.MAX, 2);

        if (param.length() > 0){
            String[] candidateNames = param.split(",");
            int len = candidateNames.length;


            Candidate[] expected = new Candidate[len];

            int counter = 0;
            for (String name : candidateNames){
                expected[counter] = Candidate.valueOf(name);
                counter++;
            }

            assertArrayEquals(expected, election.getCandidatesWithMoreVotesThan(limit));
        }else{
            Candidate[] expected = new Candidate[0];
            assertArrayEquals(expected, election.getCandidatesWithMoreVotesThan(limit));
        }
    }
}