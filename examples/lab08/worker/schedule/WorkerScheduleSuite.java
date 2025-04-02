package worker.schedule;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    WorkerScheduleStructureTest.class,
    WorkerScheduleTest.class,
})
public class WorkerScheduleSuite {}
