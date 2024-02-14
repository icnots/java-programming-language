package cards;


public class PipCard extends Card{
    private final int value;
    
    public int getValue(){
        return value;
    }


    public PipCard(Suit suit, int value){
        super(suit);
        if (0 < value && value < 11){
            this.value = value;
        }else{
            throw new IllegalArgumentException();
        }
    }
    
    @Override
    public String toString(){
        if (value == 1){
            return "ACE of " + super.toString();
        }else{
            return super.toString() + "(" + value + ")";
        }
    }
}
