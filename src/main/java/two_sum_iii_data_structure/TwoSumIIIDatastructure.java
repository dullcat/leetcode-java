package two_sum_iii_data_structure;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TwoSumIIIDatastructure {

    // Insert your Solution class here
    class TwoSum {
        Set<Integer> nums;
        Set<Integer> dups;
        /** Initialize your data structure here. */
        public TwoSum() {
            nums = new HashSet<Integer>();
            dups = new HashSet<Integer>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (nums.contains(number)) dups.add(number);
            else nums.add(number);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for(int i: nums) {
                if (i == value-i) {
                    if (dups.contains(i)) return true;
                }
                else {
                    if (nums.contains(value-i)) return true;
                }
            }
            return false;
        }
    }

    /**
     * Your TwoSum object will be instantiated and called as such:
     * TwoSum obj = new TwoSum();
     * obj.add(number);
     * boolean param_2 = obj.find(value);
     */
    public static class UnitTest {
        @Test
        public void testTwoSumIIIDatastructure() {
            //Solution s = new TwoSumIIIDatastructure().new Solution();
        }
    }
}

