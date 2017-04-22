package max_points_on_a_line;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import common.*;
public class MaxPointsonaLine {

    // Insert your Solution class here
    /**
     * Definition for a point.
     * class Point {
     *     int x;
     *     int y;
     *     Point() { x = 0; y = 0; }
     *     Point(int a, int b) { x = a; y = b; }
     * }
     */
    public class Solution {
        public int maxPoints(Point[] points) {
            if (points.length < 3) return points.length;
            int max = 2;

            for (int i=0; i<points.length-1; i++) {
                int curMax = maxPoints(points, i);
                max = Math.max(max, curMax);
            }

            return max;
        }

        int maxPoints(Point[] points, int start) {
            if (start >= points.length-1) return 1;
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();

            int samePoints = 1;
            for (int i=start+1; i<points.length; i++) {
                if (points[start].x == points[i].x && points[start].y == points[i].y) {
                    samePoints++;
                    continue;
                }
                double slope = slope(points[start], points[i]);
                if (!map.containsKey(slope)) {
                    map.put(slope, 1);
                }
                else {
                    map.put(slope, map.get(slope) + 1);
                }
            }

            int max = samePoints;

            for (int val: map.values()) {
                max = Math.max(max, val + samePoints);
            }
            return max;
        }
        double slope(Point a, Point b) {
            if (a.x == b.x) return Integer.MAX_VALUE;
            if (a.y == b.y) return 0.0;
            return (double)(b.y-a.y) / (double)(b.x-a.x);

        }
    }
    public static class UnitTest {
        @Test
        public void testMaxPointsonaLine() {
            Solution s = new MaxPointsonaLine().new Solution();
            Point[] ps = new Point[3];
            ps[0] = new Point(0,0);
            ps[1] = new Point(94911151,94911150);
            ps[2] = new Point(94911152,94911151);
            int a = s.maxPoints(ps);
            assertTrue(a==2);
        }
    }
}

