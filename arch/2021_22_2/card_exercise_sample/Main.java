import cards.Deck;

class Main{
    public static void main(String[] args){
        Deck d = Deck.makeFrenchDeckRandom();
        
        while (!d.isEmpty()){
            System.out.println(d.draw());
        }
    }
    
}
