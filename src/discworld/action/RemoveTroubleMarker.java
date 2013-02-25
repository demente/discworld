package discworld.action;

public class RemoveTroubleMarker implements Action{

	@Override
	public void toggleAction(ActionParameters params) {
		params.getSelectedArea().removeTroubleMarker();
	}

}
