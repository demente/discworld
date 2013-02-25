package discworld.action;

public class WithdrawMoney implements Action{

	int moneyAmount;
	
	public WithdrawMoney(int m){
		this.moneyAmount = m;
	}
	
	@Override
	public void toggleAction(ActionParameters params) {
		if(params.getSelectedPlayer() != null){
			//take money from player
			params.getActivePlayer().addMoney(moneyAmount);
			params.getSelectedPlayer().removeMoney(moneyAmount);
		}
		else{//take money from bank
			params.getActivePlayer().addMoney(moneyAmount);
		}
	}

}
