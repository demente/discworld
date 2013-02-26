package discworld.action;

public class WithdrawMoney implements Action{

	private String name;
	int moneyAmount;
	boolean fromPlayer;
	
	public WithdrawMoney(String name, int m){
		this.name = name;
		this.moneyAmount = m;
	}
	
	public WithdrawMoney(String name, int m,boolean fromPlayer){
		this.name = name;
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

	@Override
	public String getName() {
		return name;
	}

	public int getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(int moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	public boolean isFromPlayer() {
		return fromPlayer;
	}

	public void setFromPlayer(boolean fromPlayer) {
		this.fromPlayer = fromPlayer;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
