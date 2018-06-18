package total_hamming_distance;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TotalHammingDistance {

//    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
//    Now your job is to find the total Hamming distance between all pairs of the given numbers.
//
//            Example:
//    Input: 4, 14, 2
//
//    Output: 6
//
//    Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
//    showing the four bits relevant in this case). So the answer will be:
//    HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
//    Note:
//    Elements of the given array are in the range of 0 to 10^9
//    Length of the array will not exceed 10^4.
    // Insert your Solution class here
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int res = 0;
            int n = nums.length;
            for (int i=0; i<32; i++) {
                int oneNum = 0;
                for (int j=0; j<n; j++) {
                    oneNum += (nums[j] >> i) & 1;
                }
                res += oneNum * (n-oneNum);
            }

            return res;
        }
    }
    class Solution1 {
        public int totalHammingDistance(int[] nums) {
            int res = 0;
            for (int i=0; i<nums.length-1; i++) {
                for (int j=i+1; j<nums.length; j++) {
                    res += hamDist(nums[i], nums[j]);
                }
            }

            return res;
        }
        private int hamDist(int a, int b) {
            int c = a^b;
            int res = 0;
            while (c > 0) {
                res += c & 1;
                c = c >> 1;
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void testTotalHammingDistance() {
            Solution s = new TotalHammingDistance().new Solution();
        }
    }
}

