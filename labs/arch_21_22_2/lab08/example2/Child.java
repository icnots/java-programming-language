class Child extends Base{
    Child(){
       this(17, "tomika");
       System.out.println("constructor of Child()");
       name = "lacika";
    }
    Child(int i, String name){
        super(i, name); 
        System.out.println("constructor of Child(int i, String name){");
    }
    
    @Override
    void baseMethod(){
        System.out.println("baseMethod of Child");
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
