package discworld.model.personality;

import discworld.model.asset.CityArea;
import discworld.model.player.Player;

import java.util.List;

public class Vetinari implements Personality {
    @Override
    public boolean hasWon(Integer numberOfPlayers, Player activePlayer, List<CityArea> cityAreas) {
        return false;
    }

    // Lord Vetinari – you win if at the
    // beginning of your turn you have a certain
    // number of minions in different areas on
    // the board (think of them as your spies).
    // With two players you need to have
    // minions in at least eleven different areas.
    // With three players you need to have
    // minions in at least ten different areas.
    // With four players you need to have
    // minions in at least nine different areas.
    // Areas must be free of demons.

}
