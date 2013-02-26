package discworld.map;

import discworld.action.Action;
import discworld.model.player.Player;

public class Building {

	private Player player;
	private String name;
	private Action effect;
	private int price;

	public Building(Player p, String name, int price) {
		this.player = p;
		this.name = name;
		this.price = price;
	}
	
	public Building(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Action getEffect() {
		return effect;
	}

	public void setEffect(Action effect) {
		this.effect = effect;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
