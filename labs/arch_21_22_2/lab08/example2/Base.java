class Base{
    private int i;
    protected String name;
    
    Base(){
        System.out.println("constructor of Base()");
        i = 12;
        name = "sanyika";
    }
    Base(int i, String name){
        System.out.println("constructor of Base(int i, String name)");
        this.i = i;
        this.name = name;
    }
    
    void baseMethod(){
        System.out.println("baseMethod of Base");
    }
    
    @Override
    public String toString(){
        return "i: "+i+", name: "+name;
    }
}

