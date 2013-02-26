package discworld.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import discworld.action.Action;
import discworld.action.BuildHouse;
import discworld.action.PutMinion;
import discworld.action.RemoveMinion;
import discworld.action.RemoveTroubleMarker;
import discworld.action.TakeCard;
import discworld.action.WithdrawMoney;
import discworld.cards.Card;
import discworld.cards.RandomEvent;
import discworld.map.MapArea;
import discworld.model.player.Color;
import discworld.model.player.Personality;
import discworld.model.player.Player;

public class GameState {

	private  List<Player> players = new ArrayList<Player>();
	private int numberOfPlayers;
	private  int activePlayer;
	private List<MapArea> mapAreas = new ArrayList<MapArea>();
	private Queue<Card> drawDeck = new LinkedList<Card>();
	private Queue<RandomEvent> randomEvents = new LinkedList<RandomEvent>();

	public GameState(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}


	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}



	public  Player getActivePlayer() {
		return players.get(activePlayer);
	}

	public  void setActivePlayer(int p) {
		activePlayer = p;
	}

	public List<MapArea> getMapAreas() {
		return mapAreas;
	}

	public List<Card> drawCard(int n) {
		List<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < n; i++) {
			cards.add(drawDeck.poll());
		}
		return cards;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Queue<Card> getDrawDeck() {
		return drawDeck;
	}

	public void setDrawDeck(Queue<Card> drawDeck) {
		this.drawDeck = drawDeck;
	}

	public Queue<RandomEvent> getRandomEvents() {
		return randomEvents;
	}

	public void setRandomEvents(Queue<RandomEvent> randomEvents) {
		this.randomEvents = randomEvents;
	}

	public void setMapAreas(List<MapArea> mapAreas) {
		this.mapAreas = mapAreas;
	}

	
	
}

