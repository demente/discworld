package discworld.model.asset;

public class Minion {

    private CityArea cityArea;

    public CityArea getCityArea() {
        return cityArea;
    }

    public void setCityArea(CityArea cityArea) {
        this.cityArea = cityArea;
        cityArea.addMinion(this);
    }
}
