package discworld.map;

import java.util.List;

import discworld.model.minion.Minion;
import discworld.model.player.Player;

public class MapArea {

	private String name;
	private int number;
	private List<Minion> minions;
	private Building building;
	private List<MapArea> adajentAreas;
	private boolean troubleMarker;

	public MapArea(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public MapArea(String name, int number, List<Minion> minions,
			boolean troubleMarker) {
		this.name = name;
		this.number = number;
		this.minions = minions;
		this.troubleMarker = troubleMarker;
	}

	public void addTroubleMarker() {
		troubleMarker = true;
	}

	public void removeTroubleMarker() {
		troubleMarker = false;
	}

	public boolean hasTroubleMarker() {
		return troubleMarker;
	}

	/**
	 * Return number of player in control of this area
	 * 
	 * @return number of player in control or -1 if none
	 */
	public int getPlayerInControl() {
		// TODO: must take into account trolls and buildings!
		return -1;
	}

	public List<Minion> getMinions() {
		return minions;
	}

	public void setMinions(List<Minion> minions) {
		this.minions = minions;
	}

	public void buildBuilding(Building b) {
		building = b;
	}

	public void removeBuilding() {
		building = null;
	}

	public Building getBuilding() {
		return building;
	}

	public List<MapArea> getAdajentAreas() {
		return adajentAreas;
	}

	public void addAdajentArea(MapArea area) {
		adajentAreas.add(area);
	}

	public void addAdajentArea(List<MapArea> areas) {
		adajentAreas.addAll(areas);
	}

	public boolean isAdajent(MapArea area) {
		return getAdajentAreas().contains(area);
	}
	
	public boolean isAdajent(int area) {
		for(MapArea a : getAdajentAreas()){
			if(a.number ==area) return true;
		}
		return false;
	}
}
