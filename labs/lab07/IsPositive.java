class IsPositive{
    public static int f(int p){
        if (p < 0){
            throw new IllegalArgumentException();
        }else if (p == 0){
            return 0;
        }else{
            return 1;
        }
    }

}
