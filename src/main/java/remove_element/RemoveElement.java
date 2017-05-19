package remove_element;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RemoveElement {

    // Insert your Solution class here
    public class Solution {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            for (int j=0; j<nums.length; j++) {
                if (nums[j] == val) continue;
                nums[i++] = nums[j];
            }
            return i;
        }
    }
    public static class UnitTest {
        @Test
        public void testRemoveElement() {
            Solution s = new RemoveElement().new Solution();
        }
    }
}

