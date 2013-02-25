package discworld.game;

import java.util.ArrayList;
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

	private  List<Player> players;
	private  int activePlayer;
	private List<MapArea> mapAreas;
	private Queue<Card> drawDeck;
	private Queue<RandomEvent> randomEvents;

	public GameState(int numberOfPlayers) {
		Color[] colors = Color.values();
		List<Personality> personalities = new ArrayList<Personality>();
		for(int i=0;i<numberOfPlayers;i++){
			Personality personality = Personality.getRandomPersonality(personalities);
			personalities.add(personality);
			players.add(new Player(personality, colors[i], i));
		}
		initiateDeck();
	}

	private void initiateDeck(){
		for(int i =0;i<10;i++){
		List<Action> action = new ArrayList<Action>();
		action.add(new RemoveMinion());
		action.add(new WithdrawMoney(2));
		action.add(new PutMinion());
		Card c = new Card("The Agony Aunts",action);
		
		List<Action> action2 = new ArrayList<Action>();
		action2.add(new RemoveTroubleMarker());
		Card c2 = new Card("Angua",action2);
		
		List<Action> action3 = new ArrayList<Action>();
		action3.add(new PutMinion());
		Card c3 = new Card("Groat",action3);
		
		List<Action> action4 = new ArrayList<Action>();
		action3.add(new BuildHouse());
		Card c4 = new Card("Mr Slant",action4);
		
		drawDeck.add(c);
		drawDeck.add(c2);
		drawDeck.add(c3);
		drawDeck.add(c4);
		}
		
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

