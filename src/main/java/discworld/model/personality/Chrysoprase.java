package discworld.model.personality;

import discworld.model.asset.CityArea;
import discworld.model.player.Player;

import java.util.List;

public class Chrysoprase implements Personality {
    @Override
    public boolean hasWon(Integer numberOfPlayers, Player activePlayer, List<CityArea> cityAreas) {
        return activePlayer.getNetWorth() >= 50;
    }

    // Chrysoprase – If at the beginning of your turn your net worth
    // (your cash plus the monetary cost of each building you have)
    // is $50 or more then you win the game. Please note that any
    // loans you have taken out count as $12 against your total
    // worth (certain cards allow you to take out loans).
}
