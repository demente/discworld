package discworld.test;

import java.util.ArrayList;
import java.util.List;

import discworld.action.Action;
import discworld.action.PutMinion;
import discworld.cards.Card;
import discworld.dice.Dice;
import discworld.model.minion.Minion;
import discworld.model.player.Color;
import discworld.model.player.Personality;
import discworld.model.player.Player;

public class Test {

	public static void main(String[] args) {
		int[] p = {0,0,0,0};
		List<Minion> minions = new ArrayList<Minion>();
		Player p1 = new Player(Personality.VETINARI, Color.BLUE, 1);
		Player p2 = new Player(Personality.VETINARI, Color.BLUE, 2);
		Player p3 = new Player(Personality.VETINARI, Color.BLUE, 3);
		Minion m1 = new Minion(p1);
		Minion m2 = new Minion(p1);
		Minion m3 = new Minion(p2);
		Minion m4 = new Minion(p2);
		minions.add(m1);
		minions.add(m2);
		minions.add(m4);
		minions.add(m3);
		PutMinion pm = new PutMinion();
		List<Action> actions = new ArrayList<Action>();
		actions.add(pm);
		//Mr Boggis
		//take $2 from every other player
		//put minion
		Card c = new Card("Mr boggis", actions,p1);
		c.toggleAction(actions.get(0));
		for(int i=0;i<10000;i++){
		int rollDice = Dice.roll();
		if(rollDice > 12){
			System.out.println("Wriong");
		}
		}
	}
}

