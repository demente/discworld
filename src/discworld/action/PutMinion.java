package discworld.action;

import java.util.List;
import java.util.Scanner;

import discworld.map.MapArea;
import discworld.model.minion.Minion;
import discworld.model.player.Player;

public class PutMinion implements Action {
	private String name;
	
	public PutMinion(String name) {
	this.name = name;
	}
	@Override
	public void toggleAction(ActionParameters params) {
		Player activePlayer = params.getActivePlayer();
		activePlayer.getUnassignedMinions().get(0).add(params.getSelectedArea());
		if(params.getSelectedArea().getMinions().size()>1){
			params.getSelectedArea().addTroubleMarker();
		}
		//check if is adajent to areas with minions
		//TODO: check adajency before toggling action and availability of unassigned minions
//		List<MapArea> areasWithMinions = activePlayer.getAreasWithMinions();
//		for(MapArea a : areasWithMinions){
//			if(a.isAdajent(params.getSelectedArea())){
//				//if adajent add
//				
//				break;
//			}
//		}
		//else error message
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
