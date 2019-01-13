package discworld.model.player;

import discworld.model.asset.Building;
import discworld.model.asset.CityArea;
import discworld.model.asset.Minion;
import discworld.model.asset.PlayerMinion;
import discworld.model.personality.Personality;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private static final int MINIONS_AMOUNT = 12;
    private static final int BUILDING_AMOUNT = 6;

    private String name;

    private Color color;

    private List<PlayerMinion> minions;

    private List<Building> buildings;

    private Integer dollars;

    private List<Card> hand = new ArrayList<>();

    private List<Card> activeCards = new ArrayList<>();

    private Personality personality;

    public Player(Color color, Personality personality) {
        this.color = color;
        this.personality = personality;
        this.minions = generateMinions();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<PlayerMinion> getMinions() {
        return Collections.unmodifiableList(minions);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public Integer getDollars() {
        return dollars;
    }

    public void setDollars(Integer dollars) {
        this.dollars = dollars;
    }

    public Integer getPoints() {
        return null;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getActiveCards() {
        return activeCards;
    }

    public void setActiveCards(List<Card> activeCards) {
        this.activeCards = activeCards;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public List<Minion> getUnassignedMinions() {
        return minions.stream().filter(minion -> minion.getCityArea() == null).collect(Collectors.toList());
    }

    public Integer getNetWorth() {
        return dollars;
    }

    public List<CityArea> getControlledAreas() {
        return getMinions().stream().filter(minion -> minion.getCityArea() != null).map(minion -> minion.getCityArea())
                .filter(cityArea -> this.equals(cityArea.getControllingPlayer())).distinct().collect(Collectors.toList());
    }

    public List<CityArea> getOccupiedAreas() {
        return minions.stream()
                .filter(playerMinion -> playerMinion.getCityArea() != null)
                .map(PlayerMinion::getCityArea)
                .filter(cityArea -> !cityArea.hasDemons())
                .distinct()
                .collect(Collectors.toList());
    }

    private List<PlayerMinion> generateMinions() {
        List<PlayerMinion> playerMinions = new ArrayList<>();
        for (int i = 0; i < MINIONS_AMOUNT; i++) {
            playerMinions.add(new PlayerMinion(this));
        }
        return playerMinions;
    }
}
