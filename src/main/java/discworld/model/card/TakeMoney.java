package discworld.model.card;

public class TakeMoney implements CardAction {

    private final Integer amount;

    public TakeMoney(Integer amount) {
        this.amount = amount;
    }
}
