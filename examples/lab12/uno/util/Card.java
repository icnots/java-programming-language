package uno.util;

import java.util.Objects;

public class Card {
    public final Color color;
    public final CardType type;
    public final int value;

    public Card(Color color, CardType type, int value) {
        this.color = color;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        String info = type == CardType.VALUE ? "" + value : type.toString();
        return "%s %s".formatted(color, info);
    }

    public boolean isPlayableOver(Card other) {
        if (type != CardType.VALUE)  return other.type == CardType.VALUE && color == other.color;
        return color == other.color || value == other.value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Card card) {
            return color == card.color && type == card.type && value == card.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, value);
    }
}
