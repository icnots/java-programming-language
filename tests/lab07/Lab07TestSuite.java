
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import textfile.StatisticsTest;
import textfile.lookup.FileContentTest;

@Suite
@SelectClasses({
	DataProcessorStructureTest.class
	, SingleLineFileStructureTest.class
	, MultiLineFileStructureTest.class
	, SumCheckerStructureTest.class
    , StatisticsTest.class
    , FileContentTest.class
})
public class Lab07TestSuite {}
