package discworld.action;

import java.util.ArrayList;
import java.util.List;

import discworld.cards.Card;
import discworld.cards.RandomEvent;
import discworld.map.Building;
import discworld.map.MapArea;
import discworld.model.minion.Minion;
import discworld.model.player.Player;

public class ActionParameters {

	private Player activePlayer;
	private Player selectedPlayer;
	private List<Player> players = new ArrayList<Player>();
	private List<MapArea> mapAreas = new ArrayList<MapArea>();
	private MapArea selectedArea;
	private Building building;
	private Card nextCard;
	private RandomEvent randomEvent;
	private Minion selectedMinion;
	private int moneyAmount;
	private int numberOfCards;
	private List<Card> selectedCards;

	// TODO: add constructors

	public ActionParameters(MapArea selectedArea) {
		this.selectedArea = selectedArea;
	}
	
	public ActionParameters(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public ActionParameters(Player activePlayer,MapArea selectedArea) {
		this.activePlayer = activePlayer;
		this.selectedArea = selectedArea;
	}
	
	public ActionParameters(Player activePlayer,Player selectedPlayer) {
		this.activePlayer = activePlayer;
		this.players.add(selectedPlayer);
	}


	public Player getActivePlayer() {
		return activePlayer;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

	public List<Card> getSelectedCards() {
		return selectedCards;
	}

	public void setSelectedCards(List<Card> selectedCards) {
		this.selectedCards = selectedCards;
	}

	public int getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(int moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	public Minion getSelectedMinion() {
		return selectedMinion;
	}

	public void setSelectedMinion(Minion selectedMinion) {
		this.selectedMinion = selectedMinion;
	}

	public Player getSelectedPlayer() {
		return selectedPlayer;
	}

	public void setSelectedPlayer(Player selectedPlayer) {
		this.selectedPlayer = selectedPlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<MapArea> getMapAreas() {
		return mapAreas;
	}

	public void setMapAreas(List<MapArea> mapAreas) {
		this.mapAreas = mapAreas;
	}

	public MapArea getSelectedArea() {
		return selectedArea;
	}

	public void setSelectedArea(MapArea selectedArea) {
		this.selectedArea = selectedArea;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Card getNextCard() {
		return nextCard;
	}

	public void setNextCard(Card nextCard) {
		this.nextCard = nextCard;
	}

	public RandomEvent getRandomEvent() {
		return randomEvent;
	}

	public void setRandomEvent(RandomEvent randomEvent) {
		this.randomEvent = randomEvent;
	}

	public MapArea getMapAreaByNumber(int n) {
		for (MapArea ma : getMapAreas()) {
			if (ma.getNumber() == n) {
				return ma;
			}
		}
		return null;
	}

}
