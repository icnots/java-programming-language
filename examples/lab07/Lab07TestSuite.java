
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import textfile.StatisticsTest;
import textfile.StatisticsStructureTest;
import textfile.lookup.FileContentTest;
import textfile.lookup.FileContentStructureTest;
import text.to.numbers.SingleLineFileTest;
import text.to.numbers.SingleLineFileStructureTest;
import text.to.numbers.MultiLineFileTest;
import text.to.numbers.MultiLineFileStructureTest;

@Suite
@SelectClasses({
	SingleLineFileStructureTest.class,
	SingleLineFileTest.class,
	MultiLineFileStructureTest.class,
	MultiLineFileTest.class,
    StatisticsStructureTest.class,
    StatisticsTest.class,
    FileContentStructureTest.class,
    FileContentTest.class,
})
public class Lab07TestSuite {}
