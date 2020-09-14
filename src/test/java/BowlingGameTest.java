import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {
    @Test
    public void should_throw_exception_when_roundPoints_is_null() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            BowlingGame bowlingGame = new BowlingGame();
            bowlingGame.getTotalPoints(null);
        });
    }

    @Test
    public void should_throw_exception_when_roundPoints_is_empty() {
        Assertions.assertThrows(Exception.class, () -> {
            BowlingGame bowlingGame = new BowlingGame();
            bowlingGame.getTotalPoints("");
        });
    }

    @Test
    public void should_throw_exception_when_roundPoints_length_is_not_valid() {
        Assertions.assertThrows(Exception.class, () -> {
           BowlingGame bowlingGame = new BowlingGame();
           bowlingGame.getTotalPoints("2,3,4");
        });
    }

    @Test
    public void should_throw_exception_when_roundPoints_number_is_not_valid() {
        Assertions.assertThrows(Exception.class, () -> {
            BowlingGame bowlingGame = new BowlingGame();
            bowlingGame.getTotalPoints("10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 7.5");
        });
    }
}
