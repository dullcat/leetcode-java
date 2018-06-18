package longest_substring_with_at_most_two_distinct_characters;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    // Insert your Solution class here
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s == null || s.length() == 0) return 0;

            HashMap<Character, Integer> map = new HashMap();
            int count = 0;
            int max = 0;
            int from = 0, to = 0;

            while (to < s.length()) {
                if (map.containsKey(s.charAt(to))) {
                    map.put(s.charAt(to), map.get(s.charAt(to))+1);
                    to++;
                    count++;
                    max = Math.max(max, count);
                }
                else {
                    if (map.size() < 2) {
                        map.put(s.charAt(to), 1);
                        to++;
                        count++;
                        max = Math.max(max, count);
                    }
                    else {
                        int c = map.get(s.charAt(from));
                        if (c==1) map.remove(s.charAt(from));
                        else map.put(s.charAt(from), c-1);
                        from++;
                        count--;
                    }
                }
            }
            return max;
        }
    }
    public static class UnitTest {
        @Test
        public void testLongestSubstringwithAtMostTwoDistinctCharacters() {
            Solution s = new LongestSubstringwithAtMostTwoDistinctCharacters().new Solution();
            assertEquals(s.lengthOfLongestSubstringTwoDistinct(""), 0);
            assertEquals(s.lengthOfLongestSubstringTwoDistinct("eceba"), 3);
        }
    }
}

