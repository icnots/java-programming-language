package uno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import uno.util.Card;
import uno.util.CardType;
import uno.util.Color;
import uno.util.InputSource;
import uno.util.NotEnoughPlayersException;

public class Game {
    LinkedList<Card> deck = new LinkedList<>();
    List<Player> players;
    Card currentCard;

    int currentPlayerIdx;
    boolean isForward;
    boolean isOn;

    InputSource inputSource;
    
    public Game(int initCardCount, InputSource inputSource, String... playerNames) throws NotEnoughPlayersException {
        if (playerNames.length < 2) {
            throw new NotEnoughPlayersException(playerNames.length);
        }
        
        this.inputSource = inputSource;

        initDeck();
        initPlayers(initCardCount, playerNames);

        List<Card> initCard = drawCards(1);
        currentCard = initCard.get(0);
        
        currentPlayerIdx = playerNames.length-1;
        isForward = true;
        isOn = true;
    }

    private void initDeck() {
        deck = new LinkedList<>();
        for (Color color : Color.values()) {
            for (int value = 1; value <= 9; ++value) {
                deck.add(new Card(color, CardType.VALUE, value));
            }
            for (int i = 1; i <= 2; ++i) {
                deck.add(new Card(color, CardType.SKIP, 0));
                deck.add(new Card(color, CardType.TAKE, 0));
                deck.add(new Card(color, CardType.REVERSE, 0));
            }
        }

        if (inputSource.isInteractive) {
            Collections.shuffle(deck);
        } else {
            Collections.shuffle(deck, new java.util.Random(12345));
        }
    }

    private void initPlayers(int initCardCount, String... playerNames) {
        players = new LinkedList<>();
        for (String playerName : playerNames) {
            List<Card> hand = drawCards(initCardCount);
            players.add(new Player(playerName, hand, this));
        }
    }

    private List<Card> drawCards(int count) {
        List<Card> retval = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Card card = deck.remove();
            retval.add(card);
        }
        return retval;
    }

    public static void main(String[] args) throws NotEnoughPlayersException {
        // fake args
        args = "P1 P2".split(" ");
        
        Game game = new Game(6, new InputSource(true), args);

        while (game.isOn) {
            game.playNext();
        }
    }

    public void playNext() {
        int nextPlayerIdx = getNextPlayerIdx();
        Player nextPlayer = players.get(nextPlayerIdx);
        interactiveMsg("Current card: " + currentCard);
        interactiveMsg(nextPlayer.toString());

        currentPlayerIdx = nextPlayerIdx;
        
        int nextCardIdx = inputSource.getNextInput();
        if (nextCardIdx == InputSource.DONE) {
            interactiveMsg("Game is done");
            isOn = false;
            return;
        }

        Card card = nextPlayer.getHand().get(nextCardIdx);
        if (card.isPlayableOver(currentCard)) {
            nextPlayer.removeFromHand(nextCardIdx);
            currentCard = card;
            interactiveMsg(nextPlayer.getName() + " plays a card: " + card);
            
            useCardEffect();
        } else {
            currentPlayerDrawCard();
        }

        if (nextPlayer.getHand().isEmpty()) {
            interactiveMsg(nextPlayer.getName() + " won the game");
            isOn = false;
        }
    }

    private void useCardEffect() {
        switch (currentCard.type) {
        case REVERSE:
            isForward = !isForward;
            interactiveMsg("Effect: order is reversed");
            break;
        case SKIP:
            currentPlayerIdx = getNextPlayerIdx();
            interactiveMsg("Effect: %s is skipped".formatted(getCurrentPlayer().getName()));
            break;
        case TAKE:
            currentPlayerIdx = getNextPlayerIdx();
            interactiveMsg("Effect: %s draws a card".formatted(getCurrentPlayer().getName()));
            currentPlayerDrawCard();
            break;
        default:
            break;
        }
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
    
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
    }

    private void currentPlayerDrawCard() {
        Player currentPlayer = getCurrentPlayer();
        List<Card> drawCards = drawCards(1);
        currentPlayer.addToHand(drawCards);
        interactiveMsg(currentPlayer.getName() + " draws a card: " + drawCards.get(0));
    }

    private void interactiveMsg(String msg) {
        if (inputSource.isInteractive) {
            System.out.println(msg);
        }
    }

    public int getNextPlayerIdx() {
        var nextIdx = currentPlayerIdx + (isForward ? 1 : -1) + players.size();
        return nextIdx % players.size();
    }
}
