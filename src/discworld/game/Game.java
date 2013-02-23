package discworld.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import discworld.cards.Card;
import discworld.cards.RandomEvent;
import discworld.map.MapArea;
import discworld.model.player.Player;

public class Game {

	private List<Player> players;
	private int activePlayer;
	private List<MapArea> mapAreas;
	private Queue<Card> drawDeck;
	private Queue<RandomEvent> randomEvents;

	public Game(int numberOfPlayers) {

	}

	private Player getActivePlayer() {
		return players.get(activePlayer);
	}

	private void setActivePlayer(int p) {
		this.activePlayer = p;
	}

	private List<MapArea> getMapAreas() {
		return mapAreas;
	}

	private List<Card> drawCard(int n) {
		List<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < n; i++) {
			cards.add(drawDeck.poll());
		}
		return cards;
	}

	private RandomEvent toggleRandomEvent() {
		return randomEvents.poll();
	}
}
