class Rational{
    int numerator, denominator;
    static int nextId = 0;
    int id;
    
    private Rational(int num, denom){
        if (denom <= 0){
            throw new IllegalArgumentException();
        }
        numerator = num;
        denominator = denom;
        
        id = nextId++;
    }
    
    public static Rational oneOver(int n){
        return new Rational(1, n);
        
        
        String s;
        
        if (s.matches("[a-zA-Z0-9]")){
            // valami
        
        }
    }
    
    public static Rational fromInteger(int n){
        return new Rational(n, 1);
    }

}
