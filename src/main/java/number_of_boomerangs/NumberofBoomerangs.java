package number_of_boomerangs;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NumberofBoomerangs {
//    Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
//
//    Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
//
//    Example:
//    Input:
//            [[0,0],[1,0],[2,0]]
//
//    Output:
//            2
//
//    Explanation:
//    The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

    // Insert your Solution class here
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            HashMap<Long, Integer>[] map = new HashMap[points.length];
            for (int i=0; i<points.length; i++) {
                map[i] = new HashMap<Long, Integer>();
            }
            for (int i=0; i<=points.length-2; i++) {
                for (int j=i+1; j<=points.length-1; j++) {
                    int dx = points[i][0]-points[j][0];
                    int dy = points[i][1]-points[j][1];
                    long d = dx * dx + dy * dy;
                    if (!map[i].containsKey(d)) {
                        map[i].put(d, 1);
                    }
                    else {
                        map[i].put(d, map[i].get(d)+1);
                    }
                    if (!map[j].containsKey(d)) {
                        map[j].put(d, 1);
                    }
                    else {
                        map[j].put(d, map[j].get(d)+1);
                    }
                }
            }

            int res = 0;
            for (int i=0; i<points.length; i++) {
                for (long l : map[i].keySet()) {
                    int n = map[i].get(l);
                    if (n > 1)
                        res += n * (n-1);
                }
            }

            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testNumberofBoomerangs() {
            Solution s = new NumberofBoomerangs().new Solution();
        }
    }
}

