package discworld.action;

public class RemoveTroubleMarker implements Action{
	private String name;
	
	public RemoveTroubleMarker(String name) {
this.name = name;
	}
	@Override
	public void toggleAction(ActionParameters params) {
		params.getSelectedArea().removeTroubleMarker();
	}

	@Override
	public String getName() {
		return name;
	}

}
