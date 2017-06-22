package maximum_distance_in_arrays;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MaximumDistanceinArrays {

    // Insert your Solution class here
    public class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            Comparator<List<Integer>> comp = new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(o1.size()-1)-o2.get(o2.size()-1);
                }
            };

            Collections.sort(arrays, comp);
            int max = 0;
            List<Integer> last = arrays.get(arrays.size()-1);
            for (int i=0; i<arrays.size()-1; i++) {
                max = Math.max(max, Math.abs(last.get(last.size()-1) - arrays.get(i).get(0)));
            }
            List<Integer> nextLast = arrays.get(arrays.size()-2);
            max = Math.max(max, Math.abs(nextLast.get(nextLast.size()-1) - last.get(0)));
            return max;
        }
    }

    // TLE
    public class Solution1 {
        public int maxDistance(List<List<Integer>> arrays) {
            int max = 0;
            for (int i=0; i<arrays.size()-1; i++) {
                for (int j=i+1; j<arrays.size(); j++) {
                    max = Math.max(max, Math.abs(arrays.get(i).get(0) - arrays.get(j).get(arrays.get(j).size()-1)));
                    max = Math.max(max, Math.abs(arrays.get(j).get(0) - arrays.get(i).get(arrays.get(i).size()-1)));
                }
            }
            return max;
        }
    }

    // O(n)
    public class Solution2 {
        public int maxDistance(List<List<Integer>> arrays) {
            int result = Integer.MIN_VALUE;
            int max = arrays.get(0).get(arrays.get(0).size() - 1);
            int min = arrays.get(0).get(0);

            for (int i = 1; i < arrays.size(); i++) {
                result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
                result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
                max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
                min = Math.min(min, arrays.get(i).get(0));
            }

            return result;
        }
    }
    public static class UnitTest {
        @Test
        public void testMaximumDistanceinArrays() {
            Solution s = new MaximumDistanceinArrays().new Solution();
        }
    }
}

