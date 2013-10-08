package discworld;

import java.util.List;

public class GameState {

	public static final Integer CARDS_PER_HAND = 5;

	private List<Player> players;

	private List<Minion> minions;

	private List<Card> drawDeck;

	private List<TroubleMarker> troubleMarkers;

	private int currentPlayer;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player getCurrentPlayer() {
		return players.get(currentPlayer);
	}

	public int getCurrentPlayerIndex() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public List<Minion> getMinions() {
		return minions;
	}

	public void setMinions(List<Minion> minions) {
		this.minions = minions;
	}

	public List<Card> getDrawDeck() {
		return drawDeck;
	}

	public void setDrawDeck(List<Card> drawDeck) {
		this.drawDeck = drawDeck;
	}

	public List<TroubleMarker> getTroubleMarkers() {
		return troubleMarkers;
	}

	public void setTroubleMarkers(List<TroubleMarker> troubleMarkers) {
		this.troubleMarkers = troubleMarkers;
	}

}
