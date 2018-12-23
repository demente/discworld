package discworld.model.player;

import discworld.model.asset.Building;
import discworld.model.asset.Minion;
import discworld.personality.Personality;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private Color color;

    private List<Minion> minions;

    private List<Building> buildings;

    private Integer dollars;

    private List<Card> hand = new ArrayList<>();

    private List<Card> activeCards = new ArrayList<>();

    private Personality personality;

    public Player(Color color, Personality personality) {
        this.color = color;
        this.personality = personality;

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

    public List<Minion> getMinions() {
        return minions;
    }

    public void setMinions(List<Minion> minions) {
        this.minions = minions;
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
}
