package discworld.action;

public class WithdrawMoney implements Action{

	int moneyAmount;
	boolean fromPlayer;
	
	public WithdrawMoney(int m){
		this.moneyAmount = m;
	}
	
	public WithdrawMoney(int m,boolean fromPlayer){
		this.moneyAmount = m;
		this.fromPlayer = fromPlayer;
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
