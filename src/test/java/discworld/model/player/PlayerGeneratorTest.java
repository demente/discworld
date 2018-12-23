package discworld.model.player;

import discworld.personality.Chrysoprase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PlayerGeneratorTest {

    PlayerGenerator playerGenerator = new PlayerGenerator();

    @Test
    public void throwsExceptionIfAmountOfPlayersTooHigh() {
        Throwable thrown = catchThrowable(() -> playerGenerator.generatePlayers(5));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class)
                          .hasMessage("The game can be played by 2-4 players!");
    }

    @Test
    public void throwsExceptionIfAmountOfPlayersTooLow() {
        Throwable thrown = catchThrowable(() -> playerGenerator.generatePlayers(1));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class)
                          .hasMessage("The game can be played by 2-4 players!");
    }

    @Test
    public void generatesPlayers() {
        List<Player> players = playerGenerator.generatePlayers(2);

        assertThat(players).extracting(Player::getColor).containsExactly(Color.RED, Color.GREEN);
        assertThat(players).extracting(Player::getPersonality).isNotInstanceOf(Chrysoprase.class);
    }

}
