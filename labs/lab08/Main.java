class Main{
    public static void main( String[] args ){
        Child c = new Child();
        Parent p = new Parent();
        
        /* referring to protected field: */
        System.out.println(p.name());
        
        System.out.println("c: "+c);
        System.out.println("p: "+p);
        System.out.println();
        
        
        System.out.println("c simple method:");
        
        System.out.println();
        System.out.println("p simple method:");
        
        System.out.println();
        p = c;
        System.out.println("p simple method if it referes to c:");
        
        System.out.println();
        
        
        System.out.println("Child static method:");
        
        System.out.println("");
        
        
        System.out.println("Parent static method:");
        
    }

}