package discworld.action;

import discworld.cards.Card;

public class TakeCard implements Action {
	private String name;
	private int cardNumber;

	public TakeCard(String name, int cardNumber) {
		this.name = name;
		this.cardNumber = cardNumber;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void toggleAction(ActionParameters params) {
		if (params.getSelectedPlayer() != null) {
			for (Card c : params.getSelectedCards()) {
				params.getSelectedPlayer().getCards().remove(c);
				params.getActivePlayer().getCards().add(c);
			}
		} else {
			for (Card c : params.getSelectedCards()) {
				params.getActivePlayer().getCards().add(c);
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
