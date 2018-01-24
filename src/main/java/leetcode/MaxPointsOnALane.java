package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Dauren Mussa
 * @since 11/18/17
 */
public class MaxPointsOnALane {

    private static String input = "[[3,10],[0,2],[0,2],[3,10]]";
    private Map<String, Set<Point>> pointsMap = new HashMap<>();

    public static void main(String[] args) {
        Point[] points = parseInput();

        MaxPointsOnALane maxPointsOnALane = new MaxPointsOnALane();
        int maxPoints = maxPointsOnALane.maxPoints(points);
        System.out.println(maxPoints);
    }

    private static Point[] parseInput() {
        String[] parts = input.split("[],\\[]");
        List<Point> list = new ArrayList<>();
        int index = 1;
        int x = 0;
        int y = 0;
        for (String val : parts) {
            if (val != null && val.trim().length() > 0) {
                if (index == 1) {
                    x = Integer.valueOf(val);
                    index++;
                } else if (index == 2) {
                    y = Integer.valueOf(val);
                    index = 1;
                    list.add(new Point(x, y));
                }
            }
        }
        return list.toArray(new Point[list.size()]);
    }

    private String calcKandC(Point a, Point b) {
        double slope = (double) (a.y - b.y) / (double) (a.x - b.x);
        double c = b.y + slope * (-b.x);
        String result = "";
        if (slope == Double.NEGATIVE_INFINITY || slope == Double.POSITIVE_INFINITY) {
            result = "1x+0y=" + b.x;
        } else if (slope == 0 || Math.abs(slope) == 0) {
            result = "0x+1y=" + b.y;
        } else if (Double.isNaN(slope)) {
            result = "One point line x=" + b.x + "; y=" + b.y;
        } else {
            java.math.BigInteger Y1Y2x = java.math.BigInteger.valueOf(a.y - b.y);
            java.math.BigInteger X2X1y = java.math.BigInteger.valueOf(b.x - a.x);
            java.math.BigInteger C = java.math.BigInteger.valueOf(a.x * b.y).subtract(java.math.BigInteger.valueOf(b.x * a.y));
            java.math.BigInteger gcd1 = Y1Y2x.gcd(X2X1y);
            gcd1 = gcd1.gcd(C);

            Y1Y2x = Y1Y2x.divide(gcd1);
            X2X1y = X2X1y.divide(gcd1);
            C = C.divide(gcd1);

            if (Y1Y2x.intValue() < 0) {
                Y1Y2x = Y1Y2x.negate();
                X2X1y = X2X1y.negate();
                C = C.negate();
            }

            String formula = Y1Y2x + "x + " + X2X1y + "y + " + C + "=0";

            result = formula;
        }
        return result;
    }

    public int maxPoints(Point[] points) {
        int max = points.length > 0 ? 1 : 0;
        for (int i = 0; i < points.length - 1; i++) {
            int duplicates = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[j].y == points[i].y) {
                    duplicates++;
                } else {
                    String data = calcKandC(points[i], points[j]);
                    Set<Point> set = pointsMap.get(data);
                    if (set == null) {
                        set = new HashSet<>();
                        pointsMap.put(data, set);
                    }
                    set.add(points[i]);
                    set.add(points[j]);
                }
            }
        }

        for (Map.Entry<String, Set<Point>> entry : pointsMap.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
            }
        }

        return max;
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Point{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }

}
