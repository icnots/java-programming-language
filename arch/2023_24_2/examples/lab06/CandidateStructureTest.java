import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class CandidateStructureTest {
    @Test
    public void testEnum() {
        CheckThat.theEnum("election.candidate.Candidate")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .hasEnumElements("JACK", "JILL", "SAM", "MAX");
    }
}

