package single_element_in_a_sorted_array;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SingleElementinaSortedArray {

    // Insert your Solution class here
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int m = l + (r-l) / 2;
                if ((m & 1) == 1) m--;

                if (m+1<nums.length && nums[m] == nums[m+1]) l = m + 2;
                else r = m;
            }

            return nums[l];
        }
    }
    public static class UnitTest {
        @Test
        public void testSingleElementinaSortedArray() {
            Solution s = new SingleElementinaSortedArray().new Solution();
        }
    }
}

