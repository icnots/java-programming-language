class Main{
    public static void main( String[] args ){
        Child c = new Child();
        Parent p = new Parent();
        
        /* referring to protected field: */
        System.out.println(p.getName());
        
        System.out.println("c: "+c);
        System.out.println("p: "+p);
        System.out.println();
        
        
        System.out.println("c simple method:");
        c.simpleMethod();
        System.out.println();
        System.out.println("p simple method:");
        p.simpleMethod();
        System.out.println();
        /*Parent*/p = /*Child*/c;
        System.out.println("p simple method if it referes to c:");
        p.simpleMethod();
        
        System.out.println();
        
        
        System.out.println("Child static method:");
        Child.staticMethod();
        System.out.println("");
        
        
        System.out.println("Parent static method:");
        Parent.staticMethod();
        
        System.out.println("constructing child with parameters:");
        Child c2 = new Child("Ferenc", 26);
    }

}
