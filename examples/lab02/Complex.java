public class Complex {
    private double re, im;
    
    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }
    
    public double abs(){
        return Math.sqrt(re * re + im * im);
    }
    
    // this is the add method in the exercise
    public void increaseBy(Complex that){
        this.re += that.re;
        this.im += that.im;
    }
    
    // this is the sub method in the exercise
    public void decreaseBy(Complex that){
        this.re -= that.re;
        this.im -= that.im;
    }
    
    // this is the mul method in the exercise
    public void scaleBy(Complex that){
        double reValue = re * that.re - im * that.im;
        this.im = re * that.im + im * that.re;
        this.re = reValue;
    }
    
    public Complex add(Complex that){
        return new Complex(
            this.re + that.re,
            this.im + that.im
        );
    }

    public Complex sub(Complex that){
        return new Complex(
            this.re - that.re,
            this.im - that.im
        );
    }

    public Complex mul(Complex that){
        return new Complex(
            this.re * that.re - this.im * that.im,
            this.re * that.im + this.im * that.re
        );
    }
    
    public String toString(){
        return re + " + " + im + "i";
    }
}

