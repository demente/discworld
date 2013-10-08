package discworld;

import java.util.List;

public class Game {

	private static GameState state;

	/**
	 * 
	 * @return true if the game ended
	 */
	private boolean nextTurn() {
		// change active player
		changeActivePlayer();
		// check victory conditions
		if (checkVictoryConditions()) {
			return true;
		}

		// draw cards if neccecery
		drawCards();

		// ask player to chose card to play

		// play card

		// end turn
		return false;

	}

	/**
	 * get current active player, select next from the array of players, if
	 * active player is the last - change player to 1st
	 */
	private static void changeActivePlayer() {
		int i = state.getCurrentPlayerIndex();
		if (i < state.getPlayers().size()) {
			state.setCurrentPlayer(i + 1);
		} else {
			state.setCurrentPlayer(0);
		}

	}

	private static boolean checkVictoryConditions() {
		Player player = state.getCurrentPlayer();
		return player.hasWon(new VictoryParams(state.getDrawDeck().size(),
				state.getPlayers().size(), state.getTroubleMarkers().size(),
				state.getMinions()));
	}

	private static void drawCards() {
		Player player = state.getCurrentPlayer();
		List<Card> deck = state.getDrawDeck();
		for (int i = 0; i < GameState.CARDS_PER_HAND - player.getCards().size(); i++) {
			player.getCards().add(deck.remove(i));
		}

	}
}
