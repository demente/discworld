package discworld.service;

import discworld.factory.PersonalityCollection;
import discworld.model.player.Color;
import discworld.model.player.Player;
import discworld.model.personality.Chrysoprase;
import discworld.model.personality.Personality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class PlayerGenerator {

    public static final int MAX_NUMBER_PLAYERS = 4;
    public static final int MIN_NUMBER_PLAYERS = 2;

    private List<Personality> availablePersonalities;

    private List<Color> availableColors;

    public PlayerGenerator() {
        availablePersonalities = new ArrayList<>(PersonalityCollection.personalities());
        availableColors = new ArrayList<>(asList(Color.values()));
        Collections.shuffle(availablePersonalities);
    }

    public List<Player> generatePlayers(Integer amount) {
        if (amount > MAX_NUMBER_PLAYERS || amount < MIN_NUMBER_PLAYERS) {
            throw new UnsupportedOperationException("The game can be played by 2-4 players!");
        }
        if (amount == MIN_NUMBER_PLAYERS) {
            removeChrysoprase();
        }

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            players.add(generatePlayer());
        }
        return players;
    }

    private void removeChrysoprase() {
        Optional<Personality> chrysoprase = availablePersonalities.stream()
                .filter(personality -> personality instanceof Chrysoprase)
                .findFirst();
        availablePersonalities.remove(chrysoprase);
    }

    private Player generatePlayer() {
        Player player = new Player(availableColors.get(0), availablePersonalities.get(0));
        availableColors.remove(0);
        availablePersonalities.remove(0);
        player.setDollars(10);
        return player;
    }
}
