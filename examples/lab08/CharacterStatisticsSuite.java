import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import text.util.CharacterStatisticsTest;

@Suite
@SelectClasses({
    CharacterStatisticsStructureTest.class
    , CharacterStatisticsTest.class
})
public class CharacterStatisticsSuite {}
