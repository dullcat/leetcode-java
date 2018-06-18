package maximize_distance_to_closest_person;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MaximizeDistancetoClosestPerson {

    // Insert your Solution class here
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int from = 0;
            int to = 0;
            int max = 0;
            while (to < seats.length) {
                while (to < seats.length && seats[to] == 1) to++;
                from = to;
                while (to < seats.length && seats[to] == 0) to++;
                if (from == 0) max = to;
                else if (to == seats.length) max = Math.max(max, to-from);
                else max = Math.max(max, (to-from-1)/2+1);
            }

            return max;
        }
    }
    public static class UnitTest {
        @Test
        public void testMaximizeDistancetoClosestPerson() {
            Solution s = new MaximizeDistancetoClosestPerson().new Solution();
        }
    }
}

