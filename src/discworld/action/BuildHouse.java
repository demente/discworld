package discworld.action;

import discworld.map.Building;

public class BuildHouse implements Action {
	private String name;
	
	public BuildHouse(String name) {
	this.name = name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void toggleAction(ActionParameters params) {
		//TODO: check for minions in that area and that no building is built
		params.getSelectedArea().buildBuilding(params.getBuilding());
	}

	@Override
	public String getName() {
		return name;
	}

}
