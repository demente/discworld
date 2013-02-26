package discworld.action;

import discworld.cards.Card;

public class DiscardCard implements Action {
	private String name;
	private int cardNumber;
	
	public DiscardCard(String name,int cardNumber){
		this.name = name;
		this.cardNumber = cardNumber;
	}
	
	@Override
	public void toggleAction(ActionParameters params) {
		if (params.getSelectedPlayer() != null) {
			for (Card c : params.getSelectedCards()) {
				params.getSelectedPlayer().getCards().remove(c);
			}
		} else {
			for (Card c : params.getSelectedCards()) {
				params.getActivePlayer().getCards().remove(c);
			}
		}

	}

	@Override
	public String getName() {
		return name;
	}

}
