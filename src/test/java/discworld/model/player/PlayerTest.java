package discworld.model.player;

import discworld.model.asset.*;
import discworld.model.personality.Vetinari;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    public void returnsUnassignedMinions() {
        Player player = new Player(Color.GREEN, new Vetinari());

        Minion playerMinion = player.getMinions().get(0);
        playerMinion.setCityArea(new CityArea(CityAreaName.DOLLY_SISTERS, 6));

        assertThat(player.getUnassignedMinions()).hasSize(11);
        assertThat(player.getUnassignedMinions()).extracting(Minion::getCityArea).containsOnlyNulls();
    }

    @Test
    public void initializedMinions() {
        Player player = new Player(Color.GREEN, new Vetinari());

        assertThat(player.getMinions()).hasSize(12);
        assertThat(player.getMinions()).extracting(PlayerMinion::getOwner).containsOnly(player);
    }

    @Test
    public void returnsControlledAreas() {
        Player player = new Player(Color.GREEN, new Vetinari());
        CityArea dollySisters = new CityArea(CityAreaName.DOLLY_SISTERS, 6);
        CityArea isleOfGods = new CityArea(CityAreaName.ISLE_OF_GODS, 6);

        isleOfGods.addMinion(new Demon());
        dollySisters.addMinion(new Troll());
        player.getMinions().get(0).setCityArea(isleOfGods);
        player.getMinions().get(1).setCityArea(dollySisters);
        player.getMinions().get(3).setCityArea(dollySisters);

        assertThat(player.getControlledAreas()).containsExactly(dollySisters);
    }

    @Test
    public void returnsOccupiedAreas() {
        CityArea dollySisters = new CityArea(CityAreaName.DOLLY_SISTERS, 6);
        CityArea isleOfGods = new CityArea(CityAreaName.ISLE_OF_GODS, 6);
        isleOfGods.addMinion(new Demon());

        Player player = new Player(Color.GREEN, new Vetinari());

        Minion minion1 = player.getMinions().get(0);
        Minion minion2 = player.getMinions().get(1);
        Minion minion3 = player.getMinions().get(2);
        minion1.setCityArea(dollySisters);
        minion2.setCityArea(dollySisters);
        minion3.setCityArea(isleOfGods);

        assertThat(player.getOccupiedAreas()).hasSize(1);
        assertThat(player.getOccupiedAreas()).extracting(CityArea::getName).containsOnly(CityAreaName.DOLLY_SISTERS);
    }

}