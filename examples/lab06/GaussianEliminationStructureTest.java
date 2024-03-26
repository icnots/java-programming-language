import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class GaussianEliminationStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("linear.algebra.GaussianElimination")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldRows() {
        it.hasField("rows: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void fieldCols() {
        it.hasField("cols: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void fieldMatrix() {
        it.hasField("matrix: array of array of double")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withParams("int", "int", "array of array of double"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodArgMax() {
        it.hasMethod("argMax", withParams("int", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturns("int");
    }

    @Test
    public void methodBackSubstitution() {
        it.hasMethodWithNoParams("backSubstitution")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodCheckMatrixDimensions() {
        it.hasMethod("checkMatrixDimensions", withParams("array of array of double"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodMultiplyAndAddRow() {
        it.hasMethod("multiplyAndAddRow", withParams("int", "int", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodMultiplyRow() {
        it.hasMethod("multiplyRow", withParams("int", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodPrint() {
        it.hasMethodWithNoParams("print")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodRowEchelonForm() {
        it.hasMethodWithNoParams("rowEchelonForm")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodSwapRows() {
        it.hasMethod("swapRows", withParams("int", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }
}

