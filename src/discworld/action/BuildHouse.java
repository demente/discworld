package discworld.action;

import discworld.map.Building;

public class BuildHouse implements Action {

	@Override
	public void toggleAction(ActionParameters params) {
		//TODO: check for minions in that area and that no building is built
		params.getSelectedArea().buildBuilding(params.getBuilding());
	}

}
