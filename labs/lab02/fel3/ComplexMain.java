class ComplexMain{
    public static void main(String[] args){
        Complex c1 = new Complex(2.0, 1.0);
        Complex c2 = new Complex();
    
        Complex c3 = c1.product(c2);
        Complex c4 = c1.product(c3);
        System.out.println("c1: "+c1.re+" + " + c1.im + "*i");
        System.out.println("c2: "+c2.re+" + " + c2.im + "*i");
        System.out.println("c3: "+c3.re+" + " + c3.im + "*i");
        System.out.println("c4: "+c4.re+" + " + c4.im + "*i");
    }

}
