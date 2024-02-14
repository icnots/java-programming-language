public class Fakt{
    public static void main(String[] args){
        System.out.println("fakt(6): "+fakt(6));
        System.out.println("fakt(0): "+fakt(0));
    }
    
    public static int fakt(int p){
        if (p < 2){
            return 1;
        }else{
            return p*fakt(p-1);
        }
    }
    

}
