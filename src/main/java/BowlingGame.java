public class BowlingGame {
    public int getTotalPoints(String roundPoints) {
        if (roundPoints == null) {
            throw new NullPointerException();
        }
        if (roundPoints.length() == 0) {
            throw new Error("roundPoints is Empty!");
        }
        return 0;
    }
}
