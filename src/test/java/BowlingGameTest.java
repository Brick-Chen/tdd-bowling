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
}
