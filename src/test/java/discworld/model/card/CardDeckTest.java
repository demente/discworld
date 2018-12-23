package discworld.model.card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CardDeckTest {

    private CardDeck cardDeck;

    @Test
    public void drawsCards() {
        List<PlayerCard> expected = new ArrayList<>();
        expected.add(new PlayerCard("Card 1", asList(new PlaceMinion())));
        expected.add(new PlayerCard("Card 2", asList(new PlaceMinion())));
        cardDeck = new CardDeck(expected);

        List<PlayerCard> actual = cardDeck.draw(2);

        assertThat(actual).hasSize(2);
        assertThat(cardDeck.isEmpty()).isTrue();
    }

    @Test
    public void discardsCards() {
        List<PlayerCard> expected = new ArrayList<>();
        expected.add(new PlayerCard("Card 1", asList(new PlaceMinion())));
        expected.add(new PlayerCard("Card 2", asList(new PlaceMinion())));
        cardDeck = new CardDeck(expected);

        cardDeck.discard(expected);
        assertThat(cardDeck.isEmpty()).isTrue();
    }

}
