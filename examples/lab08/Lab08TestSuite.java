
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import worker.schedule.WorkerScheduleSuite;
import data.structure.ListUtilSuite;


@Suite
@SelectClasses({
    WorkerScheduleSuite.class,
    ListUtilSuite.class,
    //, CharacterStatisticsSuite.class
})
public class Lab08TestSuite {}
