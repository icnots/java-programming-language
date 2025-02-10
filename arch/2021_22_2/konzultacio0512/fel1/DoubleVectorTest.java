import static org.junit.Assert.*;
import org.junit.Test;

public class DoubleVectorTest{
    // RST
    
    @Test
    public void reflexivity(){
        DoubleVector dv = new DoubleVector(2, 4);
        assertTrue(dv.equals(dv));
        
        dv = new DoubleVector(-987, 477);
        assertTrue(dv.equals(dv));
    }
    
    @Test
    public void symmetricity(){
        DoubleVector dv1 = new DoubleVector(207, -411);
        DoubleVector dv2 = new DoubleVector(207, -411);
        if (dv1.equals(dv2)){
            assertTrue(dv2.equals(dv1));
        }else{
            assertFalse(dv2.equals(dv1));
        }
        
        
        dv1 = new DoubleVector(2070, -411);
        dv2 = new DoubleVector(207, -4110);
        if (dv1.equals(dv2)){
            assertTrue(dv2.equals(dv1));
        }else{
            assertFalse(dv2.equals(dv1));
        }
    }
    
    @Test
    public void transitivity(){
        DoubleVector v1 = new DoubleVector(2, 9);
        DoubleVector v2 = new DoubleVector(2, 9);
        DoubleVector v3 = new DoubleVector(2, 9);
        
        if (v1.equals(v2) && v2.equals(v3)){
            assertTrue(v3.equals(v1));
        }
        
        v1 = new DoubleVector(2, 9);
        v2 = new DoubleVector(2, 91);
        v3 = new DoubleVector(2, 91);
        
        if (v1.equals(v2) && v2.equals(v3)){
            assertTrue(v3.equals(v1));
        }
    }
    
    @Test
    public void hashTest(){
        DoubleVector v1 = new DoubleVector(2, 9);
        DoubleVector v2 = new DoubleVector(2, 9);
        
        if (v1.equals(v2)){
            assertEquals(v1.hashCode(), v2.hashCode());
        }
        
        
        v1 = new DoubleVector(2, 9);
        v2 = new DoubleVector(2, 91);
    
        if (v1.equals(v2)){
            assertEquals(v1.hashCode(), v2.hashCode());
        }
    }
    
    

}
