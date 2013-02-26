package discworld.cards;

import java.util.List;

import discworld.action.Action;
import discworld.model.player.Player;

public class Card {

	private String name;
	private List<Action> actions;
	private Player owner;
	
	public Card(String name, List<Action> actions){
		this.name = name;
		this.actions = actions;
	}
	
	
	public Card(String name, List<Action> actions,Player p){
		this.name = name;
		this.actions = actions;
		this.owner = p;
	}
	
	public void toggleAction(Action a){
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Action> getActions() {
		return actions;
	}


	public void setActions(List<Action> actions) {
		this.actions = actions;
	}


	public Player getOwner() {
		return owner;
	}


	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	
	
}
