package discworld.model.asset;

import discworld.model.player.Player;

public class PlayerMinion extends Minion {

    private final Player owner;

    public PlayerMinion(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
