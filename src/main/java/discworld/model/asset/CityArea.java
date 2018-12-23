package discworld.model.asset;

import discworld.model.player.Player;

import java.util.List;

public class CityArea {

    private String name;
    private Integer buildingPrice;
    private boolean nextToTheRiver;
    private List<CityArea> adajentAreas;
    private Object effect;

    //a way to distinguish between player with the house and the owner of the card?
    private Building building;
    private Player owner;

    private List<Minion> minions;

    public CityArea(String name, Integer buildingPrice, boolean nextToTheRiver) {
        this.name = name;
        this.buildingPrice = buildingPrice;
        this.nextToTheRiver = nextToTheRiver;
    }
}
