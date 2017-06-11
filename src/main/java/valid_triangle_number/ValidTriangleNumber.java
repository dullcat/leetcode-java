package valid_triangle_number;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ValidTriangleNumber {

    // Insert your Solution class here
    public class Solution {
        public int triangleNumber(int[] nums) {
            int res = 0;
            Arrays.sort(nums);
            for (int n1=0; n1<nums.length-2; n1++) {
                for (int n2=n1+1; n2<nums.length-1; n2++) {
                    int left = n2 + 1, right = nums.length - 1;
                    while (left < right) {
                        int n3 = left + (right - left + 1) / 2;
                        if (nums[n3] < nums[n1] + nums[n2]) {
                            left = n3;
                        }
                        else {
                            right = n3 - 1;
                        }
                    }
                    if (nums[left] < nums[n1] + nums[n2]) {
                        res += left - n2;
                    }
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testValidTriangleNumber() {
            Solution s = new ValidTriangleNumber().new Solution();
            assertEquals(3, s.triangleNumber(new int[] {2,2,3,4}));
        }
    }
}

