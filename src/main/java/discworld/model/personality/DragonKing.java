package discworld.model.personality;

import discworld.model.asset.CityArea;
import discworld.model.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class DragonKing implements Personality {

    @Override
    public boolean hasWon(Integer numberOfPlayers, Player activePlayer, List<CityArea> cityAreas) {
        return cityAreas.stream().filter(cityArea -> cityArea.hasTroubleMarker()).collect(Collectors.toList()).size() >= 8;
    }

    // Dragon King of Arms – If at the beginning of your turn
    // there are eight trouble markers on the board then you win.
    // The rationale is that the city has fallen into more chaos than
    // normal and people want the king back (who would be
    // controlled by you).
}
