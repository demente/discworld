package discworld.model.asset;

import discworld.model.player.Player;

public class Building {

    private Player owner;

    public Building(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
