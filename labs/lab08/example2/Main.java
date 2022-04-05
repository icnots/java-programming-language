class Main{
    public static void main(String[] args){
        Child c = new Child();
        Base b = new Base();
        
        c.baseMethod();
        b.baseMethod();
    
        Base d = new Child();
        d.baseMethod();
        
        Base[] a = new Base[]{new Base(), new Child(), new Base()};
        
        for (Base q : a){
            q.baseMethod();
        }
    }

}
