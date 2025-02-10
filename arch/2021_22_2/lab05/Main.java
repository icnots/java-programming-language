/** @author Agoston Kaposi
 *  @since 3.1
 *  @version 3.7
 */
public class Main {
    public static void main(String[] args){
        Fruit f = Fruit.APPLE;
        f.printElem();    
    }
}
 
 
enum Fruit{
    APPLE(310),
    BANANA(200);
    private final int weight;
    
    /** Constructor of the class.
     *   
     *  @param weight weight of the fruit
     *  @return with an instance of the class
     */
    Fruit(int weight){
        this.weight = weight;
    }
    
    public int getWeight(){ return weight; }    
    
    void printElem(){
        System.out.println("weight: " + weight);
        System.out.println(this);
    }   
    
    static void printAll(){
        for ( Fruit f : Fruit.values() ){
            f.printElem();
        }
    }
    
    
    

}
