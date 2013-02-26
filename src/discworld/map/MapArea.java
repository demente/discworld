package discworld.map;

import java.util.ArrayList;
import java.util.List;

import discworld.model.minion.Minion;
import discworld.model.player.Player;

public class MapArea {

	private String name;
	private int number;
	private List<Minion> minions = new ArrayList<Minion>();
	private Building building;
	private List<MapArea> adajentAreas = new ArrayList<MapArea>();
	private boolean troubleMarker;
	private boolean adajentToRiver; //TODO: add to constructor

	public MapArea(String name, int number, boolean river) {
		this.name = name;
		this.number = number;
		this.adajentToRiver = river;
	}

	public MapArea(String name, int number, List<Minion> minions,
			boolean troubleMarker, boolean river) {
		this.name = name;
		this.number = number;
		this.minions = minions;
		this.troubleMarker = troubleMarker;
		this.adajentToRiver = river;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdajentToRiver() {
		return adajentToRiver;
	}

	public void setAdajentToRiver(boolean adajentToRiver) {
		this.adajentToRiver = adajentToRiver;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isTroubleMarker() {
		return troubleMarker;
	}

	public void setTroubleMarker(boolean troubleMarker) {
		this.troubleMarker = troubleMarker;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public void setAdajentAreas(List<MapArea> adajentAreas) {
		this.adajentAreas = adajentAreas;
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
	
	public boolean isAdajent(List<MapArea> areas) {
		for(MapArea ma : areas){
			if(isAdajent(ma)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isAdajent(int area) {
		for(MapArea a : getAdajentAreas()){
			if(a.number ==area) return true;
		}
		return false;
	}
}
