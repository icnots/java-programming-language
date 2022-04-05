class Parent{
    protected String name;
    int age;
    protected Parent(){
        System.out.println("Parent() constructor is running");
        name = "Default Name";
        age = 40;
    }
    Parent( String name ){
        System.out.println("Parent(String) constructor is running");
        this.name = name;
        this.age = 40;
    }
    Parent( String name, int age ){
        System.out.println("Parent(String, int) constructor is running");
        this.name = name;
        this.age = age;
    }
    
    void simpleMethod(){
        System.out.println("This is a simple method of Parent.");
    }
    
    @Override
    public String toString(){
        return "Parent: "+name+", age: "+age;
    }

    static void staticMethod(){
        System.out.println("This is a static method of Parent.");        
    }
    
    public String getName(){
        return name;
    }
}
