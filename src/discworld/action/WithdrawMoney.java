package discworld.action;

public class WithdrawMoney implements Action{

	@Override
	public void toggleAction(ActionParameters params) {
		if(params.getSelectedPlayer() != null){
			//take money from player
			params.getActivePlayer().addMoney(params.getMoneyAmount());
			params.getSelectedPlayer().removeMoney(params.getMoneyAmount());
		}
		else{//take money from bank
			params.getActivePlayer().addMoney(params.getMoneyAmount());
		}
	}

}
