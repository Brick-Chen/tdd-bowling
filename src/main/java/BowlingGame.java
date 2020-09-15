import java.util.Arrays;

public class BowlingGame {
    private final static int FULL_SCORE = 10;
    private final static int TOTAL_ROUND = 10;
    private final static int MIN_TIME = 11;
    private final static int MAX_TIME = 21;

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
        if (points.length < MIN_TIME || points.length > MAX_TIME) {
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

    private int calculate(int[] points) throws Exception {
        int round = 0;
        int pos = 0;
        int sum = 0;
        while(round < TOTAL_ROUND) {
            if (points[pos] < FULL_SCORE) {
                int roundSum = points[pos] + points[pos + 1];
                if (roundSum < FULL_SCORE) {
                    sum += roundSum;
                }
                else if (roundSum == FULL_SCORE) {
                    sum += FULL_SCORE + points[pos + 2];
                }
                else {
                    throw new Exception("Invalid round total scores!");
                }
                pos += 2;
            }
            else if (points[pos] == FULL_SCORE) {
                sum += FULL_SCORE + points[pos + 1] + points[pos + 2];
                pos += 1;
            }
            else {
                throw new Exception("Invalid input score");
            }
            ++round;
        }
        return sum;
    }

}
