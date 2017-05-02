package container_with_most_water;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ContainerWithMostWater {

    // Insert your Solution class here
    public class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int left = 0, right = height.length-1;
            while (left < right) {
                max = Math.max(max, Math.min(height[left], height[right]) * (right-left));
                if (height[left] <= height[right]) left++;
                else right--;
            }
            return max;
        }
    }

    // brute force. timeout in oj.
    public class Solution1 {
        public int maxArea(int[] height) {
            int max = 0;
            for(int i=0; i<height.length-1; i++) {
                for (int j=i+1; j<height.length; j++) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (j-i));
                }
            }
            return max;
        }
    }
    public static class UnitTest {
        @Test
        public void testContainerWithMostWater() {
            Solution s = new ContainerWithMostWater().new Solution();
        }
    }
}

