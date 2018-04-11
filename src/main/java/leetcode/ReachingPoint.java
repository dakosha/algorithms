package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dauren Mussa
 * @since 2/17/18
 */
public class ReachingPoint {

    public static void main(String[] args) {
        int x1 = 1;
        int y1 = 8;
        int x2 = 4;
        int y2 = 15;

        ReachingPoint reachingPoint = new ReachingPoint();
        System.out.println(reachingPoint.reachingPoints(x1, y1, x2, y2));

        //System.out.println(reachingPoint.reachingPoints(x1, y1, x2, y2));
    }

    public boolean reachingPoints(int x1, int y1, int x2, int y2) {
        boolean swapped = false;
        while (true) {
            if (x1 == x2 && y1 == y2) {
                return true;
            }

            if ((x2<x1 || y2<y1) && !swapped) {
                int temp = x2;
                x2 = x1;
                x1 = temp;

                temp = y2;
                y2 = y1;
                y1 = temp;

                swapped = true;
            }

            if (x2 == 0 || y2 == 0) {
                return false;
            }
            if (x2 > y2) {
                int multi = x2 / y2;
                int dif = multi * y2;
                if (x2 % y2 == 0) {
                    dif -= y2;
                }
                x2 = x2 - dif;
            } else if (x2 < y2) {
                int multi = y2 / x2;
                int dif = multi * x2;
                if (y2 % x2 == 0) {
                    dif -= x2;
                }
                y2 = y2 - dif;
            } else {
                return false;
            }
        }
    }

    public List<Point> nextMoves(Point point, Point dest) {
        List<Point> res = new LinkedList<>();
        Point p1 = new Point(point.x, point.x + point.y);
        if (p1.x <= dest.x && p1.y <= dest.y) {
            res.add(p1);
        }
        Point p2 = new Point(point.x + point.y, point.y);
        if (p2.x <= dest.x && p2.y <= dest.y) {
            res.add(p2);
        }
        return res;
    }

    public boolean reachingPoints2(int x1, int y1, int x2, int y2) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x1, y1));
        Point dest = new Point(x2, y2);

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            queue.addAll(nextMoves(point, dest));

            if (point.x == x2 && point.y == y2) {
                return true;
            }
        }

        return false;
    }

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ":" + this.y + ")";
        }
    }

}
