package discworld.model.asset;

import discworld.model.personality.Vetinari;
import discworld.model.personality.Vimes;
import discworld.model.player.Color;
import discworld.model.player.Player;
import org.junit.jupiter.api.Test;

import static discworld.model.asset.CityAreaName.DOLLY_SISTERS;
import static org.assertj.core.api.Assertions.assertThat;

class CityAreaTest {

    private Player owner = new Player(Color.GREEN, new Vimes());

    @Test
    public void addsMinion() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);
        Minion expected = new PlayerMinion(owner);

        dollySister.addMinion(expected);

        assertThat(dollySister.getMinions()).contains(expected);
    }

    @Test
    public void returnsAmountOfTrolls() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);

        dollySister.addMinion(new Troll());
        dollySister.addMinion(new Troll());

        assertThat(dollySister.getTrollsAmount()).isEqualTo(2);
    }

    @Test
    public void addsTroubleMarkerIfMoreThanOneMinionIsAdded() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);

        dollySister.addMinion(new PlayerMinion(owner));
        dollySister.addMinion(new PlayerMinion(owner));

        assertThat(dollySister.hasTroubleMarker()).isTrue();
    }

    @Test
    public void doesNotAddTroubleMarkerIfOnlyOneMinionIsAdded() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);

        assertThat(dollySister.getMinions()).isEmpty();

        dollySister.addMinion(new PlayerMinion(owner));

        assertThat(dollySister.hasTroubleMarker()).isFalse();
    }

    @Test
    public void containsDemons() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);
        dollySister.addMinion(new Demon());
        dollySister.addMinion(new PlayerMinion(owner));

        assertThat(dollySister.hasDemons()).isTrue();
    }

    @Test
    public void returnsPlayerThatControlsTheArea() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);
        Player player1 = new Player(Color.GREEN, new Vetinari());
        Player player2 = new Player(Color.RED, new Vimes());

        dollySister.addMinion(new Troll());
        dollySister.addMinion(new PlayerMinion(player1));
        dollySister.addMinion(new PlayerMinion(player1));
        dollySister.addMinion(new PlayerMinion(player2));

        assertThat(dollySister.getControllingPlayer()).isEqualTo(player1);
    }

    @Test
    public void countsBuildingWhenFindingPlayerInControl() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);
        Player player1 = new Player(Color.GREEN, new Vetinari());
        Player player2 = new Player(Color.RED, new Vimes());

        dollySister.setBuilding(new Building(player2));
        dollySister.addMinion(new PlayerMinion(player1));
        dollySister.addMinion(new PlayerMinion(player2));


        assertThat(dollySister.getControllingPlayer()).isEqualTo(player2);
    }

    @Test
    public void returnsNullIfNoPlayerControlsTheAreaBecauseOfTrolls() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);
        Player player1 = new Player(Color.GREEN, new Vetinari());
        Player player2 = new Player(Color.RED, new Vimes());

        dollySister.addMinion(new Troll());
        dollySister.addMinion(new Troll());
        dollySister.addMinion(new PlayerMinion(player1));
        dollySister.addMinion(new PlayerMinion(player1));
        dollySister.addMinion(new PlayerMinion(player2));

        assertThat(dollySister.getControllingPlayer()).isNull();
    }

    @Test
    public void returnsNullIfNoPlayerControlsTheArea() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);
        Player player1 = new Player(Color.GREEN, new Vetinari());
        Player player2 = new Player(Color.RED, new Vimes());

        dollySister.addMinion(new PlayerMinion(player1));
        dollySister.addMinion(new PlayerMinion(player2));

        assertThat(dollySister.getControllingPlayer()).isNull();
    }

    @Test
    public void returnsNoPlayerInControlIfAreaContainsDemons() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);

        dollySister.addMinion(new Demon());

        assertThat(dollySister.getControllingPlayer()).isNull();
    }

    @Test
    public void returnsPlayerMinions() {
        CityArea dollySister = new CityArea(DOLLY_SISTERS, 6);
        Player player1 = new Player(Color.GREEN, new Vetinari());
        Player player2 = new Player(Color.RED, new Vimes());
        PlayerMinion minion2 = new PlayerMinion(player2);
        PlayerMinion minion1 = new PlayerMinion(player1);

        dollySister.addMinion(new Troll());
        dollySister.addMinion(new Troll());
        dollySister.addMinion(minion1);
        dollySister.addMinion(minion2);

        assertThat(dollySister.getPlayerMinions()).containsExactly(minion1, minion2);
    }

}