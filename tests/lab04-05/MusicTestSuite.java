
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import music.fan.FanTest;
import music.recording.ArtistTest;
import music.recording.RecordLabelTest;

@SelectClasses({
    MusicTestSuite.StructuralTests.class
  , MusicTestSuite.FunctionalTests.class
})
@Suite public class MusicTestSuite {
  @SelectClasses({
        RecordLabelStructureTest.class
      , ArtistStructureTest.class
      , FanStructureTest.class
  })
  @Suite public static class StructuralTests {}

  @SelectClasses({
        RecordLabelTest.class
      , ArtistTest.class
      , FanTest.class
  })
  @Suite public static class FunctionalTests {}
}
