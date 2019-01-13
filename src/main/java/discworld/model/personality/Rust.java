package discworld.model.personality;

import discworld.model.asset.CityArea;
import discworld.model.player.Player;

import java.util.List;

public class Rust implements Personality {

    @Override
    public boolean hasWon(Integer numberOfPlayers, Player activePlayer, List<CityArea> cityAreas) {
        return false;
    }
}
