package discworld.action;

public class RemoveMinion implements Action {
	private String name;
	
	public RemoveMinion(String name) {
	this.name = name;
	}
	@Override
	public void toggleAction(ActionParameters params) {
		params.getSelectedMinion().remove(params.getSelectedArea());
		if(params.getSelectedArea().getMinions().size()<2){
			params.getSelectedArea().removeTroubleMarker();
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
