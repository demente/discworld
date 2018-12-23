package discworld.model.card;

import java.util.List;

public class PlayerCard {

    private String name;
    private String text;
    private List<CardAction> actions;

    public PlayerCard(String name, List<CardAction> actions) {
        this.name = name;
        this.actions = actions;
    }

    public PlayerCard(String name, String text, List<CardAction> actions) {
        this.name = name;
        this.text = text;
        this.actions = actions;
    }
}
