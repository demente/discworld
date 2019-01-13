package discworld.model.asset;

public enum CityAreaName {
    DOLLY_SISTERS("Dolly Sisters"),
    UNREAL_ESTATE("Unreal estate"),
    DRAGONS_LANDING("Dragon's Landing"),
    SMALL_GODS("Small Gods"),
    SCOURS("The Scours"),
    SHADES("The Shades"),
    HIPPO("The Hippo"),
    DIMWELL("Dimwell"),
    LONGWALL("Longwall"),
    ISLE_OF_GODS("Isle Of Gods"),
    SEVEN_SLEEPERS("Seven Sleepers"),
    NAP_HILL("Nap Hill");

    private String name;


    CityAreaName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
