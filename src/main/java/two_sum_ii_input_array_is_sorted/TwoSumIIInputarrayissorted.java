package two_sum_ii_input_array_is_sorted;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TwoSumIIInputarrayissorted {

    // Insert your Solution class here
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] res = new int[2];
            int from = 0;
            int to = numbers.length-1;
            while (from < to) {
                int sum = numbers[from] + numbers[to];
                if (sum == target) {
                    res[0] = from+1;
                    res[1] = to+1;
                    return res;
                }
                else if (sum < target) from++;
                else to--;
            }
            return null;
        }
    }
    public static class UnitTest {
        @Test
        public void testTwoSumIIInputarrayissorted() {
            Solution s = new TwoSumIIInputarrayissorted().new Solution();
        }
    }
}

