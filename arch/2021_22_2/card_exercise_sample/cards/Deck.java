package cards;

import java.util.Stack;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck{
    private final Stack<Card> stack = new Stack<>();
    
    public Card draw(){
        if (isEmpty()){
            throw new NullPointerException("No card is in the deck!");
        }
        return stack.pop();
    }
    
    public static Deck makeFrenchDeck(){
        Deck d = new Deck();
        
        for (Suit s : Suit.values()){
            for (int i = 1; i <= 10; i++){
                d.stack.push(new PipCard(s, i));
            }
            /* ez is jó lenne
            d.stack.push(new FaceCard(s, Face.KING));}
            d.stack.push(new FaceCard(s, Face.QUEEN));}
            d.stack.push(new FaceCard(s, Face.JACK));
            */
            for (Face f : Face.values()){
                if (f != Face.CAVALIER){
                    d.stack.push(new FaceCard(s, f));
                }
            }
        }
        
        return d;        
    }
    
    
    public static Deck makeFrenchDeckRandom(){
        Deck d = new Deck();
        
        List<Card> l = new LinkedList<>();
        for (Suit s : Suit.values()){
            for (int i = 1; i <= 10; i++){
                l.add(new PipCard(s, i));
            }
            /* ez is jó lenne
            d.stack.push(new FaceCard(s, Face.KING));
            d.stack.push(new FaceCard(s, Face.QUEEN));
            d.stack.push(new FaceCard(s, Face.JACK));
            */
            for (Face f : Face.values()){
                if (f != Face.CAVALIER){
                    l.add(new FaceCard(s, f));
                }
            }
        }
        
        Random r = new Random();
        
        for (int i = 0; i < 52; i++){
            int v = r.nextInt(52 - i);
            d.stack.push(l.remove(v));        
        }

        return d;        
    }
    
    public boolean isEmpty(){
        return stack.empty();
    }
}
