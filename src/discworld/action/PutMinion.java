package discworld.action;

import java.util.List;
import java.util.Scanner;

import discworld.map.MapArea;
import discworld.model.player.Player;

public class PutMinion implements Action {

	@Override
	public void toggleAction(Player activePlayer) {
		// TODO Auto-generated method stub
		activePlayer.getUnassignedMinions();
		//ask for area number
		Scanner k = new Scanner (System.in);
		System.out.println("Enter a digit: ");
		int digit1 = k.nextInt();
		//TODO: transform digit to MapArea somehow
		//check if is adajent to areas with minions
		List<MapArea> areasWithMinions = activePlayer.getAreasWithMinions();
		boolean adajent = false;
		for(MapArea a : areasWithMinions){
			if(a.isAdajent(digit1)){
				adajent = true;
				break;
			}
		}
		//if adajent add
		
		System.out.println(digit1);
		//else error message
		
	}

}
