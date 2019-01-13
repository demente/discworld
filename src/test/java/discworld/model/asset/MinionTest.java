package discworld.model.asset;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinionTest {

    @Test
    public void addsMinionToCityAreaWhenCityAreaIsSet() {
        Minion minion = new Minion();
        CityArea cityArea = new CityArea(CityAreaName.DOLLY_SISTERS, 6);

        minion.setCityArea(cityArea);

        assertThat(cityArea.getMinions()).contains(minion);
    }

}