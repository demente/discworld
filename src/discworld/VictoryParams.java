package discworld;

import java.util.List;

public class VictoryParams {

	private Integer cardsRemaining;
	private Integer playersTotal;
	private Integer troubleMarkers;
	private List<Minion> minions;

	public VictoryParams(int cards, int players, int troubleMarkers,
			List<Minion> minions) {
		this.cardsRemaining = cards;
		this.playersTotal = players;
		this.troubleMarkers = troubleMarkers;
		this.minions = minions;

	}

	public Integer getCardsRemaining() {
		return cardsRemaining;
	}

	public void setCardsRemaining(Integer cardsRemaining) {
		this.cardsRemaining = cardsRemaining;
	}

	public Integer getPlayersTotal() {
		return playersTotal;
	}

	public void setPlayersTotal(Integer playersTotal) {
		this.playersTotal = playersTotal;
	}

	public Integer getTroubleMarkers() {
		return troubleMarkers;
	}

	public void setTroubleMarkers(Integer troubleMarkers) {
		this.troubleMarkers = troubleMarkers;
	}

	public List<Minion> getMinions() {
		return minions;
	}

	public void setMinions(List<Minion> minions) {
		this.minions = minions;
	}

}
