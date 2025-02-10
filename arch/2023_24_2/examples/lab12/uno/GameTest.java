package uno;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

import uno.util.Card;
import uno.util.CardType;
import uno.util.Color;
import uno.util.InputSource;

public class GameTest {
    @Test
    public void test() throws Exception {
        Game game = new Game(2, new InputSource(false, 1, 0, 1), "P1", "P2", "P3");
        assertEquals(new Card(Color.RED, CardType.TAKE, 0), game.currentCard);

        assertEquals(List.of(new Card(Color.GREEN, CardType.SKIP, 0), new Card(Color.RED, CardType.VALUE, 1)), game.getPlayers().get(0).getHand());
        assertEquals(List.of(new Card(Color.RED, CardType.VALUE, 3), new Card(Color.BLUE, CardType.VALUE, 8)), game.getPlayers().get(1).getHand());
        assertEquals(List.of(new Card(Color.BLUE, CardType.REVERSE, 0), new Card(Color.RED, CardType.VALUE, 8)), game.getPlayers().get(2).getHand());

        game.playNext();
        assertEquals(0, game.currentPlayerIdx);
        assertEquals(new Card(Color.RED, CardType.VALUE, 1), game.currentCard);
        assertEquals(List.of(new Card(Color.GREEN, CardType.SKIP, 0)), game.getCurrentPlayer().getHand());
        
        game.playNext();
        assertEquals(1, game.currentPlayerIdx);
        assertEquals(new Card(Color.RED, CardType.VALUE, 3), game.currentCard);
        assertEquals(List.of(new Card(Color.BLUE, CardType.VALUE, 8)), game.getCurrentPlayer().getHand());
        
        game.playNext();
        assertEquals(2, game.currentPlayerIdx);
        assertEquals(new Card(Color.RED, CardType.VALUE, 8), game.currentCard);
        assertEquals(List.of(new Card(Color.BLUE, CardType.REVERSE, 0)), game.getCurrentPlayer().getHand());

        game.playNext();

        assertFalse(game.isOn);
    }
}
