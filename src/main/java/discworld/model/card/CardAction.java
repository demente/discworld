package discworld.model.card;

public interface CardAction {

    default boolean isSkippable() {
        return true;
    }

}
