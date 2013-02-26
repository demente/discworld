package discworld.model.minion;

import discworld.map.MapArea;
import discworld.model.player.Player;

public class Minion {

	private Player player;
	private MinionType type;
	private MapArea area;

	public Minion(Player p) {
		this.player = p;
	}

	public Minion(MinionType type) {
		this.type = type;
	}

	public Minion(Player p, MinionType type) {
		this.player = p;
		this.type = type;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

	public MapArea getArea() {
		return area;
	}

	public void setArea(MapArea area) {
		this.area = area;
	}

	public void add(MapArea m) {
		m.getMinions().add(this);
		area = m;
		if(m.getMinions().size() > 1){
			m.setTroubleMarker(true);
		}
	}

	public void remove(MapArea m) {
		m.getMinions().remove(this);
		if(m.getMinions().size() < 2){
			m.setTroubleMarker(false);
		}
		area = null;
	}

	public void moveMinion(MapArea from, MapArea to) {
		if (from.isAdajent(to)) {
			add(to);
			remove(from);
		}
		// TODO:add error message in case the area is not adajent
	}

}
