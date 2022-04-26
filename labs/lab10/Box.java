class Box<T>{
    T data;
    Box(){
    }
    Box(T p){
        this.data = p;
    }
    
    T get() throws MyFancyException{
        if (data == null){
            throw new MyFancyException();
        }
        return data;
    }
    void set(T other){
        data = other;
    }
}

interface Printableeee{
    void printMe();

}

class A implements Printableeee{
    public void printMe(){
        System.out.println("Me");
    }
}
