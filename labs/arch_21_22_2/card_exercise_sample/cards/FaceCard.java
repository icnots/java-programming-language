package cards;

public class FaceCard extends Card{
    private final Face face;
    
    public Face getFace(){
        return face;
    }
    
    public FaceCard(Suit suit, Face face){
        super(suit);
        if (null == face){
            throw new IllegalArgumentException();
        }
        this.face = face;
    }
    
    @Override
    public String toString(){
        return face.name() + " of " + super.toString();
    }
}
