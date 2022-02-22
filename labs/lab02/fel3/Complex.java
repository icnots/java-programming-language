class Complex{
    double re, im;
    
    Complex(){
        re = 1;
        im = 0;
    }
    Complex(double re, double pIm){
        this.re = re;
        im = pIm;
    }
    /*void product (Complex that){
        double newRe = this.re * that.re - this.im * that.im;
        double newIm = this.re * that.im + this.im * that.re;
        re = newRe;
        im = newIm;
    }*/
    Complex product (Complex that){
        double newRe = this.re * that.re - this.im * that.im;
        double newIm = this.re * that.im + this.im * that.re;
        return new Complex(newRe, newIm);
    }
}
