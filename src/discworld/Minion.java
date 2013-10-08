package discworld;

public class Minion {

	private Player player;
	private MinionType type;
	private Area area;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public MinionType getType() {
		return type;
	}

	public void setType(MinionType type) {
		this.type = type;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
