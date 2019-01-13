package discworld.model.personality;

import discworld.model.asset.CityArea;
import discworld.model.player.Player;

import java.util.List;

public class Vimes implements Personality {
    @Override
    public boolean hasWon(Integer numberOfPlayers, Player activePlayer, List<CityArea> cityAreas) {
        return false;
    }
    // Commander Vimes – you win if nobody else wins by the
    // time the draw pile has been exhausted.
}
