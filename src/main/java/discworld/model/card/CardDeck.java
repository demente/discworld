package discworld.model.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private final List<PlayerCard> cards;

    public CardDeck(List<PlayerCard> cards) {
        this.cards = cards;
    }

    public List<PlayerCard> draw(Integer amount) {
        List<PlayerCard> drawnCards = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            drawnCards.add(cards.get(i));
        }
        discard(drawnCards);
        return drawnCards;
    }

    public void discard(List<PlayerCard> discardedCards) {
        cards.removeAll(discardedCards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
