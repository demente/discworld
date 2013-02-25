package discworld.action;

import discworld.map.MapArea;

public class MoveMinion implements Action {

	@Override
	public void toggleAction(ActionParameters params) {
		MapArea fromArea = params.getSelectedMinion().getArea();
		params.getSelectedMinion().moveMinion(fromArea, params.getSelectedArea());
		//check if remove/add trouble marker required
		if(params.getSelectedArea().getMinions().size()>1){
			params.getSelectedArea().addTroubleMarker();
		}
		if(fromArea.getMinions().size()<2){
			fromArea.removeTroubleMarker();
		}
	}

}
