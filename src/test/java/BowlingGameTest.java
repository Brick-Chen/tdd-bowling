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

    @Test
    public void should_return_correct_points_when_roundPoints_is_valid() throws Exception{
        BowlingGame bowlingGame = new BowlingGame();
        String game1 = "10,10,10,10,10,10,10,10,10,10,10,10";
        String game2 = "2,3,4,5,6,2,7,1,3,5,0,4,5,1,2,5,6,3,4,2";
        String game3 = "7,3,10,4,5,10,4,3,5,5,9,1,10,6,4,8,2,10";
        Assertions.assertEquals(300, bowlingGame.getTotalPoints(game1));
        Assertions.assertEquals(70, bowlingGame.getTotalPoints(game2));
        Assertions.assertEquals(169, bowlingGame.getTotalPoints(game3));
    }
}
