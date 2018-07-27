package pyramid_transition_matrix;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PyramidTransitionMatrix {
//    We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.
//
//    For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.
//
//    We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.
//
//    Return true if we can build the pyramid all the way to the top, otherwise false.
//
//    Example 1:
//    Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
//    Output: true
//    Explanation:
//    We can stack the pyramid like this:
//        A
//       / \
//      D   E
//     / \ / \
//    X   Y   Z
//
//    This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
//    Example 2:
//    Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
//    Output: false
//    Explanation:
//    We can't stack the pyramid to the top.
//    Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
//            Note:
//    bottom will be a string with length in range [2, 8].
//    allowed will have length in range [0, 200].
//    Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.

    // Insert your Solution class here
    class Solution {
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            Map<String, Integer> map = new HashMap<>();
            for (String s: allowed) {
                String key = s.substring(0, 2);
                if (!map.containsKey(key))
                    map.put(key, 0);
                int value = 1<<(s.charAt(2)-'A');
                map.put(key, map.get(key) | value);
            }

            return dfs(bottom, 0, new StringBuilder(), 0, map);
        }

        private boolean dfs(String cur, int index, StringBuilder next, int level, Map<String, Integer> map) {
            if (cur.length() == 1) return true;
            if (next.length() == cur.length()-1) {
                return dfs(next.toString(), 0, new StringBuilder(), level+1, map);
            }
            String set = "ABCDEFG";
            int i=index;
            String key = cur.substring(index, index+2);
            if (!map.containsKey(key)) return false;
            int val = map.get(key);
            for (int j=0; j<7; j++) {
                if ((val & (1<<j)) > 0) {
                    next.append(set.charAt(j));
                    if (dfs(cur, i+1, next, level, map)) return true;
                    next.deleteCharAt(next.length()-1);
                }
            }
            return false;
        }
    }
    public static class UnitTest {
        @Test
        public void testPyramidTransitionMatrix() {
            Solution s = new PyramidTransitionMatrix().new Solution();
        }
    }
}

