package time;

import org.junit.platform.suite.api.*;
import check.*;

@SelectClasses({
    TimeTestSuite.StructuralTests.class,
    TimeTestSuite.FunctionalTests.class,
})
@Suite public class TimeTestSuite {
    // // Uncomment to force language choice for the whole suite.
    // @BeforeSuite
    // public static void beforeSuite() {
    //     CheckThat.usedLang = CheckThat.Lang.HU;
    //     CheckThat.usedLang = CheckThat.Lang.EN;
    // }

    @SelectClasses({
        TimeStructureTest.class,
    })
    @Suite public static class StructuralTests {}

    @SelectClasses({
        TimeTest.class,
    })
    @Suite public static class FunctionalTests {}
}

