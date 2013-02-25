package discworld.action;

public class RemoveMinion implements Action {

	@Override
	public void toggleAction(ActionParameters params) {
		params.getSelectedMinion().remove(params.getSelectedArea());
		if(params.getSelectedArea().getMinions().size()<2){
			params.getSelectedArea().removeTroubleMarker();
		}
	}

}
