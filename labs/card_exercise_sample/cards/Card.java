package cards;

public abstract class Card{
    private final Suit suit;

    public Suit getSuit(){
        return suit;
    }

    Card(Suit suit){
        if (null == suit){
            throw new IllegalArgumentException();
        }
        
        this.suit = suit;
    }
    
    @Override
    public String toString(){
        return suit.toString();
    }

}
