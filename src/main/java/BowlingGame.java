import java.util.Arrays;

public class BowlingGame {
    public int getTotalPoints(String roundPoints) throws Exception {
        if (roundPoints == null) {
            throw new NullPointerException();
        }
        if (roundPoints.length() == 0) {
            throw new Exception("roundPoints is Empty!");
        }
        if (!valid(roundPoints)) {
            throw new Exception("roundPoints is not valid");
        }
        int[] points = Arrays.stream(roundPoints.split(",")).mapToInt(point -> Integer.parseInt(point.trim()))
                .toArray();
        return calculate(points);
    }

    private boolean valid(String roundPoints) {
        String[] points = roundPoints.split(",");
        if (points.length < 11 || points.length > 20) {
            return false;
        }
        boolean flag = true;
        try {
            for (String point : points) {
                point = point.trim();
                Integer.parseInt(point);
            }
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    private int calculate(int[] points) {
        return 0;
    }

}
