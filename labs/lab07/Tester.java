import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class Tester{
    @Before
    public void firstMethod(){
        System.out.println("I am the first.");
    }


    @Test
    public void test_pos(){
        assertEquals(IsPositive.f(12), 1);    
        assertEquals(IsPositive.f(1299), 1);  
    }
    
    @Test
    public void test_zero(){
        assertEquals(IsPositive.f(0), 0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_neg(){
        IsPositive.f(-12);
    }
}
