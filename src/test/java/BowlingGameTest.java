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
    public void should_throw_exception_when_one_round_point_is_greater_than_10() {
        Assertions.assertThrows(Exception.class, () -> {
           BowlingGame bowlingGame = new BowlingGame();
           bowlingGame.getTotalPoints("5,4,8,2,11,4,5,10,10,10,3,7,4,5,6,3");
        });
    }

    @Test
    public void should_throw_exception_when_sum_of_two_points_in_a_round_greater_than_10() {
        Assertions.assertThrows(Exception.class, () -> {
            BowlingGame bowlingGame = new BowlingGame();
            bowlingGame.getTotalPoints("3,7,4,6,2,7,6,5,4,6,9,1,10,10,10,7,2");
        });
    }

    @Test
    public void should_return_correct_points_when_roundPoints_is_valid() throws Exception{
        BowlingGame bowlingGame = new BowlingGame();
        String game1 = "10,10,10,10,10,10,10,10,10,10,10,10";
        String game2 = "2,3,4,5,6,2,7,1,3,5,0,4,5,1,2,5,6,3,4,2";
        String game3 = "7,3,10,4,5,10,4,3,5,5,9,1,10,6,4,8,2,10";
        String game4= "3,5,5,4,2,7,1,6,2,4,4,4,6,2,8,1,5,4,10,10,10";
        Assertions.assertEquals(300, bowlingGame.getTotalPoints(game1));
        Assertions.assertEquals(70, bowlingGame.getTotalPoints(game2));
        Assertions.assertEquals(169, bowlingGame.getTotalPoints(game3));
        Assertions.assertEquals(103, bowlingGame.getTotalPoints(game4));
    }
}
