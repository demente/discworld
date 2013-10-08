package discworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Player {

	private Personality personality;
	private List<Card> cards;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public boolean hasWon(VictoryParams params) {
		switch (personality) {
		case VETINARI:
			// Lord Vetinari – you win if at the
			// beginning of your turn you have a certain
			// number of minions in different areas on
			// the board (think of them as your spies).
			// With two players you need to have
			// minions in at least eleven different areas.
			// With three players you need to have
			// minions in at least ten different areas.
			// With four players you need to have
			// minions in at least nine different areas.
			// Areas must be free of demons.
			Set<Area> areas = new HashSet<Area>();
			List<Area> demons = new ArrayList<Area>();
			for (Minion m : params.getMinions()) {
				if (m.getType().equals(MinionType.DEMON)) {
					demons.add(m.getArea());
				}
			}
			for (Minion m : params.getMinions()) {
				if (this.equals(m.getPlayer()) && !demons.contains(m.getArea())) {
					areas.add(m.getArea());
				}
			}
			return 13 - params.getPlayersTotal() <= areas.size();
		case VIMES:
			// Commander Vimes – you win if nobody else wins by the
			// time the draw pile has been exhausted.
			return params.getCardsRemaining() < 1;
		case SELACHII:
		case RUST:
		case WORDE:
			// Lord Selachii, Lord Rust, Lord de Worde – you win if at
			// the beginning of your turn you control a certain number of
			// areas. If there are only two of you playing then you need to
			// control seven areas, if there are three of you then you need to
			// control five areas, and if there are four of you then you need
			// to control four areas. You control an area if you have more
			// playing pieces in it than any single other player (a playing
			// piece being a minion or a building). You would also have to
			// have more pieces there than the total number of trolls in the
			// area. You cannot control an area that contains one or more
			// demons. The presence of a trouble marker does not affect
			// the control of an area.
			List<Area> d = new ArrayList<Area>();
			Map<Area, Integer> trolls = new HashMap<Area, Integer>();
			Map<Area, Map<Player, Integer>> minions = new HashMap<Area, Map<Player, Integer>>();
			for (Minion m : params.getMinions()) {
				if (m.getType().equals(MinionType.DEMON)) {
					d.add(m.getArea());
				}
				if (m.getType().equals(MinionType.TROLL)) {
					trolls.put(m.getArea(), trolls.get(m.getArea()) + 1);
				}
			}
			for (Minion m : params.getMinions()) {
				Map<Player, Integer> players = minions.get(m.getArea());

				if (players == null) {
					minions.put(m.getArea(), new HashMap<Player, Integer>());
				}

				if (m.getPlayer() != null) {
					Integer num = players.get(m.getPlayer()) + 1;
					minions.get(m.getArea()).put(m.getPlayer(), num);
				}

			}
			Integer controlledAreas = 0;
			for (Area a : minions.keySet()) {
				Player maxPlayer = null;
				Integer max = -1;
				for (Player p : minions.get(a).keySet()) {
					if (max < minions.get(a).get(p)) {
						max = minions.get(a).get(p);
						maxPlayer = p;
					}
				}
				if (this.equals(maxPlayer) && !d.contains(a)
						&& trolls.get(a) < max) {
					controlledAreas++;
				}
			}
			switch (params.getPlayersTotal()) {
			case 2:
				return controlledAreas >= 7;
			case 3:
				return controlledAreas >= 5;
			case 4:
				return controlledAreas >= 4;
			default:
				return false;
			}

		case DRAGONKING:
			// Dragon King of Arms – If at the beginning of your turn
			// there are eight trouble markers on the board then you win.
			// The rationale is that the city has fallen into more chaos than
			// normal and people want the king back (who would be
			// controlled by you).
			return params.getTroubleMarkers() > 7;
		case CHRYSOPRASE:
			// Chrysoprase – If at the beginning of your turn your net worth
			// (your cash plus the monetary cost of each building you have)
			// is $50 or more then you win the game. Please note that any
			// loans you have taken out count as $12 against your total
			// worth (certain cards allow you to take out loans).
			return false;
		default:
			return false;
		}
	}
}
