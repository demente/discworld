package discworld.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import discworld.cards.Card;
import discworld.cards.RandomEvent;
import discworld.map.MapArea;
import discworld.model.player.Player;

public class Game {
	//ask for area number
//	Scanner k = new Scanner (System.in);
//	System.out.println("Enter a digit: ");
//	int digit1 = k.nextInt();
	
//	private RandomEvent toggleRandomEvent() {
//	return randomEvents.poll();
//}
	
	private static final int NUMBER_OF_PLAYERS = 2;
	
	public static void main(String[] args) {
		GameState gs = new GameState(NUMBER_OF_PLAYERS);
		gs.setActivePlayer(0);
		for(int i =0;i< gs.getPlayers().size();i++){
			
		}
	}
}
