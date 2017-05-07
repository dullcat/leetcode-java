package candy;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Candy {

    // Insert your Solution class here
    public class Solution {
        public int candy(int[] ratings) {
            if (ratings.length == 0) return 0;
            if (ratings.length == 1) return 1;

            int[] count = new int[ratings.length];
            count[0] = 1;
            for (int i=1; i<ratings.length; i++) {
                count[i] = count[i]<1? 1: count[i];
                if (ratings[i] > ratings[i-1]) {
                    count[i] = Math.max(count[i-1] + 1, count[i]);
                }
            }
            int sum = count[ratings.length-1];
            for (int i=ratings.length-1; i>0; i--) {
                if (ratings[i] < ratings[i-1]) {
                    count[i-1] = Math.max(count[i] + 1, count[i-1]);
                }
                sum += count[i-1];
            }
            return sum;
        }
    }
    public static class UnitTest {
        @Test
        public void testCandy() {
            Solution s = new Candy().new Solution();
        }
    }
}

