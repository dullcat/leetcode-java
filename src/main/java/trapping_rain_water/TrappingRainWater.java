package trapping_rain_water;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TrappingRainWater {

    // Insert your Solution class here
    class Solution {
        public int trap(int[] height) {
            if (height.length < 3) return 0;
            int sum = 0;
            int[] leftSide = new int[height.length];
            int[] rightSide = new int[height.length];
            int max = 0;
            for (int i=0; i<height.length; i++) {
                max = Math.max(max, height[i]);
                leftSide[i] = max;
            }

            max = 0;
            for (int i=height.length-1; i>=0; i--) {
                max = Math.max(max, height[i]);
                rightSide[i] = max;
            }

            for (int i=0; i<height.length; i++) {
                int minSide = Math.min(leftSide[i], rightSide[i]);
                if (minSide > height[i]) sum += minSide - height[i];
            }
            return sum;
        }
        public int trap1(int[] height) {
            if (height.length < 3) return 0;
            int sum = 0;
            int l = 0;
            int r = height.length-1;
            int highLeft = 0;
            int highRight = 0;
            while (l<r) {
                if (height[l] < height[r]) {
                    if (height[l] > highLeft)
                        highLeft = height[l];
                    else
                        sum += highLeft-height[l];
                    l++;
                }
                else {
                    if (height[r] > highRight)
                        highRight = height[r];
                    else
                        sum += highRight - height[r];
                    r--;
                }
            }

            return sum;
        }
    }
    public static class UnitTest {
        @Test
        public void testTrappingRainWater() {
            Solution s = new TrappingRainWater().new Solution();
        }
    }
}

