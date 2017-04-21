package _3sum;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class _3Sum {

    // Insert your Solution class here
    public class Solution {
        public List<List<Integer>> twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            List<List<Integer>>  res = new ArrayList<List<Integer>>();
            while (left < right) {
                if (numbers[left] + numbers[right] == target){
                    List<Integer> r = new ArrayList<Integer>();
                    r.add(numbers[left]);
                    r.add(numbers[right]);
                    res.add(r);
                    left++;
                    right--;
                    while (left < right && numbers[left]==numbers[left-1]) left++;
                    while (left < right && numbers[right]==numbers[right+1]) right--;
                }
                else if (numbers[left] + numbers[right] < target) {
                    left++;
                }
                else right--;
            }
            return res;
        }

        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            List<List<Integer>> results = new ArrayList<List<Integer>>();
            if (n < 3) return results;
            Arrays.sort(nums);
            for (int i=0; i<n-2; i++) {
                if (i>0 && nums[i] == nums[i-1]) continue;

                int[] subNums = Arrays.copyOfRange(nums, i+1, n);
                List<List<Integer>> twoRes = twoSum(subNums, -nums[i]);
                for (List<Integer> twoResRow : twoRes) {
                    List<Integer> r = new ArrayList<Integer>();
                    r.add(nums[i]);
                    r.addAll(twoResRow);
                    results.add(r);
                }
            }
            return results;
        }
    }

    public static class UnitTest {
        @Test
        public void test_3Sum() {
            Solution s = new _3Sum().new Solution();
            assertEquals(1, (s.threeSum(new int[] {1,2,-3,}).size()));
        }

    }
}

