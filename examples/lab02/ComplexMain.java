public class ComplexMain {
    public static void main(String[] args){
        Complex alpha = new Complex(3., 2.);
        Complex beta = new Complex(1., 2.);
        System.out.println("alpha: "+alpha);
        System.out.println("beta: "+beta);

        // alpha.add(beta);
        alpha.increaseBy(beta);
        System.out.println("alpha.add(beta);");
        System.out.println("alpha: "+alpha+" beta: "+beta);
        alpha.decreaseBy(beta);
        System.out.println("alpha.sub(beta);");
        System.out.println("alpha: "+alpha+" beta: "+beta);

        alpha.scaleBy(beta);
        System.out.println("alpha.mul(beta);");
        System.out.println("alpha: "+alpha+" beta: "+beta);
        
        // other pattern:
        Complex i = new Complex(0.0, 1.0);
        
        System.out.println(i + " * " + i + " = " + i.mul(i));
    }

}
