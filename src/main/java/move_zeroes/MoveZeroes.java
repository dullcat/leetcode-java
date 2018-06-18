package move_zeroes;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MoveZeroes {

    // Insert your Solution class here
    class Solution {
        public void moveZeroes(int[] nums) {
            int nz = 0;
            for (int i=0; i<nums.length; i++) {
                if (nums[i] != 0) nums[nz++] = nums[i];
            }
            for (int i=nz; i<nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testMoveZeroes() {
            Solution s = new MoveZeroes().new Solution();
        }
    }
}

