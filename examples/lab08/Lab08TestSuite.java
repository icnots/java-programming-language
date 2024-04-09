
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    WorkerScheduleSuite.class
    , ListUtilSuite.class
    , CharacterStatisticsSuite.class
})
public class Lab08TestSuite {}
