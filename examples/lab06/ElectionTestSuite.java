

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import election.ElectionTest;

@Suite
@SelectClasses({
    CandidateStructureTest.class,
	ElectionStructureTest.class,
	ElectionTestStructureTest.class,
	ElectionTest.class
})
public class ElectionTestSuite {}

