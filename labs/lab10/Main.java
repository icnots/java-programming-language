class Main{
    public static void main(String[] args){
        Box<A> b = new Box<>();
        
        try{
            A a = b.get();
        }
        catch(MyFancyException e){
            System.out.println("MyFancyException was thrown");
        }
    }
    
    static <T> void printMe(T p){
    }


}
