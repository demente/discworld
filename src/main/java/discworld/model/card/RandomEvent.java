package discworld.model.card;

public class RandomEvent implements CardAction {

    @Override
    public boolean isSkippable() {
        return false;
    }
}
