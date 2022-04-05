class Parent{
    protected String name;
    int age;
    Parent(){
        name = "Default Name";
        age = 40;
    }
    Parent( String name ){
        this.name = name;
        this.age = 40;
    }
    Parent( String name, int age ){
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
