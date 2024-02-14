class Child extends Parent{
    
    Child(){
        this( "Peter" );
        System.out.println("Child() constructor is running");
    }
    Child( String name ){
        super( name );
        System.out.println("Child(String) constructor is running");
        this.age = 18;
    }
    Child( String name, int age ){
        System.out.println("Child(String, int) constructor is running");
        this.name = name;
        this.age = age;
    }
    
    @Override
    void simpleMethod(){
        System.out.println("This is a simple method of Child.");
    }
    
    @Override
    public String toString(){
        String res = "Child: "+name+", age: "+age;
        res += " as Parent: "+super.toString();
        
        return res;
    }
    
    static void staticMethod(){
        System.out.println("This is a static method of Child.");
        /* I can call Parent's static method as well: */
        Parent.staticMethod();
    }
}
