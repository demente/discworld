package discworld.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;

import discworld.action.Action;
import discworld.action.ActionParameters;
import discworld.action.BuildHouse;
import discworld.action.DiscardCard;
import discworld.action.PutMinion;
import discworld.action.RemoveMinion;
import discworld.action.RemoveTroubleMarker;
import discworld.action.WithdrawMoney;
import discworld.cards.Card;
import discworld.map.MapArea;
import discworld.model.minion.Minion;
import discworld.model.player.Color;
import discworld.model.player.Personality;
import discworld.model.player.Player;

public class Game {
	// ask for area number
	// Scanner k = new Scanner (System.in);
	// System.out.println("Enter a digit: ");
	// int digit1 = k.nextInt();

	// private RandomEvent toggleRandomEvent() {
	// return randomEvents.poll();
	// }

	private static final int NUMBER_OF_PLAYERS = 2;

	public static void main(String[] args) {
		GameState gs = new GameState(NUMBER_OF_PLAYERS);
		createPlayers(gs);
		initiateDeck(gs);
		initiateAreas(gs);
		gs.setActivePlayer(0);
		for (int i = 0; i < gs.getPlayers().size(); i++) {
			gs.getPlayers().get(i).getCards().addAll(gs.drawCard(5));
		}
		playTurn(gs);
		System.out.println("");
	}

	private static void changeActivePlayer(GameState gs) {
		if (gs.getActivePlayer().getNumber() == gs.getNumberOfPlayers() - 1) {
			gs.setActivePlayer(0);
		} else {
			gs.setActivePlayer(gs.getActivePlayer().getNumber() + 1);
		}
		playTurn(gs);

	}

	private static void playTurn(GameState gs) {
		Player player = gs.getActivePlayer();
		// print map areas
		for (MapArea ma : gs.getMapAreas()) {
			System.out.println(ma.getName() + ":");
			for (Minion m : ma.getMinions()) {
				System.out.println(m.getPlayer().getNumber());
			}
		}

		// print available cards

		for (Card c : player.getCards()) {
			System.out.print(c.getName() + ":");
			for (Action a : c.getActions()) {
				System.out.print(a.getName() + ",");
			}
			System.out.println("");
		}

		// ask for card to play
		Scanner k = new Scanner(System.in);
		System.out.println("Chose card to play: ");
		int cardnum = k.nextInt();
		boolean actionSkipped = false;
		for (Action a : player.getCards().get(cardnum).getActions()) {
			System.out.println(a.getName());
			if (!actionSkipped) {
				System.out.println("Skip that action?");
				String skip = k.next();
				if (skip.equals("Y")) {
					continue;
				} else {
					a.toggleAction(createParamsForAction(gs, a));
				}
			}
		}
		gs.getActivePlayer().getCards().remove(player.getCards().get(cardnum));
		changeActivePlayer(gs);
	}

	private static ActionParameters createParamsForAction(GameState gs, Action a) {
		System.out.println(a.getClass().getSimpleName());
		Scanner k = new Scanner(System.in);
		int area = -1;
		switch (a.getClass().getSimpleName()) {
		case "BuildHouse":
			//TODO: check for trolls and demons
			System.out.println("Choose area to build house in:");
			for (MapArea ma : gs.getActivePlayer().getAreasWithMinions()) {
				if(ma.getBuilding() == null){
					System.out.println(ma.getName() + ":" + ma.getNumber());
				}
				}
			k = new Scanner(System.in);
			area = k.nextInt();
			//TODO: where to buildbuilding??
			return new ActionParameters(gs.getMapAreas().get(area));
			
		case "RemoveTroubleMarker":
			System.out.println("Choose area to remove trouble marker from:");
			for (MapArea ma : gs.getMapAreas()) {
				if (ma.hasTroubleMarker()) {
					System.out.println(ma.getName() + ":" + ma.getNumber());
				}
			}
			area = k.nextInt();
			return new ActionParameters(gs.getMapAreas().get(area));
		case "PutMinion":
			System.out.println("Choose area to place minion to:");
			for (MapArea ma : gs.getMapAreas()) {
				if(ma.isAdajent(gs.getActivePlayer().getAreasWithMinions())){
					System.out.println(ma.getName() + ":" + ma.getNumber());
				}
			}
			area = k.nextInt();
			return new ActionParameters(gs.getActivePlayer(),gs.getMapAreas().get(area));
		case "WithdrawMoney":
			WithdrawMoney wm = (WithdrawMoney) a;
			if(wm.isFromPlayer()){
				System.out.println("Choose a player:");
				for(Player p : gs.getPlayers()){
					if(!p.equals(gs.getActivePlayer())){
						System.out.println("player " + p.getNumber());
					}
				}
				int player = k.nextInt();
				return new ActionParameters(gs.getActivePlayer(),gs.getPlayers().get(player));
			}
			else{
				return new ActionParameters(gs.getActivePlayer());
			}
		case "DiscardCard":
			DiscardCard dc = (DiscardCard) a;
			int n = dc.getCardNumber();
			List<Card> cards = new ArrayList<Card>();
			while(n >0){
				System.out.println("Choose cards to discard");
				int card = k.nextInt();
				cards.add(gs.getActivePlayer().getCards().get(card));
			}
			return new ActionParameters(gs.getActivePlayer(), cards);
		case "TakeCard":
			return null;
		}

		return null;
	}

	private static void initiateAreas(GameState gs) {
		MapArea dolly = new MapArea("Dolly Sisters", 1, true);
		MapArea unreal = new MapArea("Unreal Estate", 2, true);
		MapArea dragon = new MapArea("Dragons landing", 3, false);
		MapArea smallgods = new MapArea("Small Gods", 4, true);
		MapArea scours = new MapArea("The Scours", 5, true);
		MapArea hippo = new MapArea("The Hippo", 6, false);
		MapArea shades = new MapArea("The Shades", 7, true);
		MapArea dimwell = new MapArea("Dimwell", 8, true);
		MapArea longwall = new MapArea("Longwall", 9, true);
		MapArea isleofgods = new MapArea("Isle of Gods", 10, true);
		MapArea sevensleepers = new MapArea("Seven Sleepers", 11, true);
		MapArea naphill = new MapArea("Nap Hill", 12, true);
		for (Player p : gs.getPlayers()) {
			p.getUnassignedMinions().get(0).add(dolly);
			p.getUnassignedMinions().get(0).add(shades);
			p.getUnassignedMinions().get(0).add(scours);
		}
		// TODO: add adajent areas

		dolly.addAdajentArea(naphill);
		dolly.addAdajentArea(unreal);
		dolly.addAdajentArea(dragon);

		unreal.addAdajentArea(dolly);
		unreal.addAdajentArea(naphill);
		unreal.addAdajentArea(sevensleepers);
		unreal.addAdajentArea(isleofgods);
		unreal.addAdajentArea(smallgods);

		dragon.addAdajentArea(dolly);
		dragon.addAdajentArea(smallgods);

		smallgods.addAdajentArea(dragon);
		smallgods.addAdajentArea(hippo);
		smallgods.addAdajentArea(scours);
		smallgods.addAdajentArea(unreal);
		smallgods.addAdajentArea(isleofgods);
		
		scours.addAdajentArea(isleofgods);
		scours.addAdajentArea(dimwell);
		scours.addAdajentArea(shades);
		scours.addAdajentArea(hippo);
		scours.addAdajentArea(smallgods);
		
		hippo.addAdajentArea(smallgods);
		hippo.addAdajentArea(scours);
		hippo.addAdajentArea(shades);
		
		shades.addAdajentArea(hippo);
		shades.addAdajentArea(scours);
		shades.addAdajentArea(dimwell);

		dimwell.addAdajentArea(scours);
		dimwell.addAdajentArea(shades);
		dimwell.addAdajentArea(longwall);

		longwall.addAdajentArea(dimwell);
		longwall.addAdajentArea(isleofgods);
		longwall.addAdajentArea(sevensleepers);
		
		isleofgods.addAdajentArea(scours);
		isleofgods.addAdajentArea(smallgods);
		isleofgods.addAdajentArea(longwall);
		isleofgods.addAdajentArea(sevensleepers);
		isleofgods.addAdajentArea(unreal);

		sevensleepers.addAdajentArea(isleofgods);
		sevensleepers.addAdajentArea(unreal);
		sevensleepers.addAdajentArea(naphill);
		
		naphill.addAdajentArea(dolly);
		naphill.addAdajentArea(unreal);
		naphill.addAdajentArea(sevensleepers);
		
		gs.getMapAreas().add(dolly);
		gs.getMapAreas().add(unreal);
		gs.getMapAreas().add(dragon);
		gs.getMapAreas().add(smallgods);
		gs.getMapAreas().add(scours);
		gs.getMapAreas().add(hippo);
		gs.getMapAreas().add(shades);
		gs.getMapAreas().add(dimwell);
		gs.getMapAreas().add(longwall);
		gs.getMapAreas().add(isleofgods);
		gs.getMapAreas().add(sevensleepers);
		gs.getMapAreas().add(naphill);

	}

	private static void createPlayers(GameState gs) {
		Color[] colors = Color.values();
		List<Personality> personalities = new ArrayList<Personality>();
		for (int i = 0; i < gs.getNumberOfPlayers(); i++) {
			Personality personality = Personality
					.getRandomPersonality(personalities);
			personalities.add(personality);
			gs.getPlayers().add(new Player(personality, colors[i], i));
		}
	}

	private static void initiateDeck(GameState gs) {
		for (int i = 0; i < 10; i++) {
			List<Action> action = new ArrayList<Action>();
			action.add(new RemoveMinion("Remove minion"));
			action.add(new WithdrawMoney("Take money", 2, false));
			action.add(new PutMinion("Place minion"));
			Card c = new Card("The Agony Aunts", action);

			List<Action> action2 = new ArrayList<Action>();
			action2.add(new RemoveTroubleMarker("Remove trouble marker"));
			Card c2 = new Card("Angua", action2);

			List<Action> action3 = new ArrayList<Action>();
			action3.add(new PutMinion("Place minion"));
			Card c3 = new Card("Groat", action3);

			List<Action> action4 = new ArrayList<Action>();
			action4.add(new BuildHouse("Build house"));
			Card c4 = new Card("Mr Slant", action4);

			gs.getDrawDeck().add(c);
			gs.getDrawDeck().add(c2);
			gs.getDrawDeck().add(c3);
			gs.getDrawDeck().add(c4);
		}

	}
}
