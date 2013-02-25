package discworld.model.player;

import java.util.ArrayList;
import java.util.List;

import discworld.cards.Card;
import discworld.map.Building;
import discworld.map.MapArea;
import discworld.model.minion.Minion;

public class Player {

	private Color color;
	private Personality personality;
	private int number; // 0,1,2,3
	private List<Building> buildings = new ArrayList<Building>();
	private int money = 10;
	private List<Minion> minions = new ArrayList<Minion>(); // all 12 minions in
															// here, some
															// assigned to area,
															// some not
	private List<Card> cards = new ArrayList<Card>();

	public Player(Personality personality, Color color, int number) {
		this.color = color;
		this.personality = personality;
		this.number = number;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Personality getPersonality() {
		return personality;
	}

	public void setPersonality(Personality personality) {
		this.personality = personality;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<Minion> getMinions() {
		return minions;
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public void removeMoney(int money) {
		this.money -= money;
	}

	public List<Minion> getUnassignedMinions() {
		List<Minion> min = new ArrayList();
		for (Minion m : minions) {
			if (m.getArea() == null) {
				min.add(m);
			}
		}
		return min;
	}

	public List<Minion> getAssignedMinions() {
		List<Minion> min = new ArrayList();
		for (Minion m : minions) {
			if (m.getArea() != null) {
				min.add(m);
			}
		}
		return min;
	}

	// TODO: check if we need to account buildings as well
	public List<MapArea> getAreasWithMinions() {
		List<MapArea> areas = new ArrayList<MapArea>();
		for (Minion m : minions) {
			if (m.getArea() != null) {
				areas.add(m.getArea());
			}
		}
		return areas;
	}

	public void setMinions(List<Minion> minions) {
		this.minions = minions;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public boolean checkWinConditions(int players) {
		switch (personality) {
		case VETINARI:

			break;
		case VIMES:
			break;
		case SELACHII:
		case RUST:
		case WORDE:
			break;
		case DRAGONKING:
			break;
		case CHRYSOPRASE:
			break;
		}
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
		// Dragon King of Arms – If at the beginning of your turn
		// there are eight trouble markers on the board then you win.
		// The rationale is that the city has fallen into more chaos than
		// normal and people want the king back (who would be
		// controlled by you).
		// Chrysoprase – If at the beginning of your turn your net worth
		// (your cash plus the monetary cost of each building you have)
		// is $50 or more then you win the game. Please note that any
		// loans you have taken out count as $12 against your total
		// worth (certain cards allow you to take out loans).
		// Commander Vimes – you win if nobody else wins by the
		// time the draw pile has been exhausted.
		return false;
	}
}
