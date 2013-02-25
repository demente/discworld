package discworld.action;

import discworld.cards.Card;

public class TakeCard implements Action{

	@Override
	public void toggleAction(ActionParameters params) {
		if(params.getSelectedPlayer() != null){
			for(Card c : params.getSelectedCards()){
			params.getSelectedPlayer().getCards().remove(c);
			params.getActivePlayer().getCards().add(c);
			}
		}
		else{
			for(Card c : params.getSelectedCards()){
			params.getActivePlayer().getCards().add(c);
			}
		}
	}

}
