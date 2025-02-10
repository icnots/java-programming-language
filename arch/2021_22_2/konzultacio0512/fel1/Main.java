import java.util.HashSet;

class Main
{
    public static void main(String[] args)
    {
        DoubleVector dv1 = new DoubleVector(2, 3);
        DoubleVector dv2 = new DoubleVector(2, 3);
        DoubleVector dv3 = new DoubleVector(2, 2);
        
        System.out.println(dv1.equals(dv2));
        System.out.println(dv1.equals(dv3));
        System.out.println(dv2.equals(dv3));
        
        System.out.println("dv1.hashCode: " + dv1.hashCode());
        System.out.println("dv2.hashCode: " + dv2.hashCode());
        System.out.println("dv3.hashCode: " + dv3.hashCode());
        
                    
        System.out.println(new DoubleVector(2, 3).equals(new DoubleVector(2, 3)));
        System.out.println(new DoubleVector(2, 3).equals(new DoubleVector(2, 2)));

        HashSet<DoubleVector> exampleSet = new HashSet<DoubleVector>();
        exampleSet.add(new DoubleVector(0, 0));
        exampleSet.add(new DoubleVector(3, -7));
        exampleSet.add(new DoubleVector(3, -7));
        System.out.println( "size of HashSet: " + exampleSet.size());
        System.out.println( "items of HashSet: " + exampleSet);
    }
}

