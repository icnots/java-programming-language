
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    ColorStructureTest.class,
    CardTypeStructureTest.class,
    CardStructureTest.class,

    PlayerStructureTest.class,

    InputSourceStructureTest.class,

    NotEnoughPlayersExceptionStructureTest.class,

    GameStructureTest.class
    
    // funkcionális tesztelő
//  , GameTest.class
})
public class UnoTestSuite {}
