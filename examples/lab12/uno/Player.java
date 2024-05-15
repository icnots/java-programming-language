package uno;
import java.util.ArrayList;
import java.util.List;

import uno.util.Card;

public class Player {
    private String name;
    private List<Card> hand;
    private Game game;

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    public Player(String name, List<Card> hand, Game game) {
        this.name = name;
        this.hand = hand;
        this.game = game;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        sb.append("Player %s: ".formatted(name));
        for (Card card : hand) {
            sb.append(idx);
            if (card.isPlayableOver(game.currentCard)) {
                sb.append("*");
            }
            sb.append("=");
            sb.append(card);
            sb.append("  ");
            ++idx;
        }
        return sb.toString();
    }

    public void addToHand(List<Card> cards) {
        hand.addAll(cards);
    }

    public void removeFromHand(int cardIdx) {
        hand.remove(cardIdx);
    }
}
