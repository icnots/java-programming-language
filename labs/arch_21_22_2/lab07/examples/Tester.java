import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tester{
    @Test(expected = IllegalArgumentException.class)
    public void test_neg_pos(){
        Calculator.power(-2,3);
    }
    
    @Test
    public void test_0_0(){
        assertEquals(
            1.0,
            Calculator.power(0,0),
            0.00000000001
        );    
    }
    
    @Test
    public void test_0_pos(){
        assertEquals(
            0.0,
            Calculator.power(0,300),
            0.00000000001
        );    
    }
    
    @Test
    public void test_pos_0(){
        assertEquals(
            1.0,
            Calculator.power(1333,0),
            0.00000000001
        );    
    }
    
    @Test
    public void test_pos_pos(){
        assertEquals(
            8.0,
            Calculator.power(2,3),
            0.00000000001
        );
        
        assertEquals(
            9.0,
            Calculator.power(3,2),
            0.00000000001
        );
        
        assertEquals(
            131.0,
            Calculator.power(131,1),
            0.00000000001
        );
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void test_pos_neg(){
        Calculator.power(2,-3);
    }
    
}
