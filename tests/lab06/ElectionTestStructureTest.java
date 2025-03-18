import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class ElectionTestStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("election.ElectionTest")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void noArgTestMethods() {
        it.hasNoArgTestMethods(
            "candidateVoteCount",
            "noVotes"
        );
    }

    @Test
    public void methodCandidateVoteCountAdvanced() {
        it.hasTestMethodWithParams("candidateVoteCountAdvanced", "int", "String");
    }

    @Test
    public void methodSingleCandidate() {
        it.hasTestMethodWithParams("singleCandidate", "election.candidate.Candidate", "int");
    }

    @Test
    public void methodTwoCandidatesSameVoteCount() {
        it.hasTestMethodWithParams("twoCandidatesSameVoteCount", "election.candidate.Candidate", "election.candidate.Candidate", "int");
    }
}

