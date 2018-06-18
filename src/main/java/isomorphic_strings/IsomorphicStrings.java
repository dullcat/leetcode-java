package isomorphic_strings;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class IsomorphicStrings {

    // Insert your Solution class here
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s == null && t == null) return true;
            if (s.length() != t.length()) return false;
            HashMap<Character, Character> map = new HashMap();
            for (int i=0; i<s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);
                if (map.containsKey(sc)) {
                    if (map.get(sc) != tc) return false;
                }
                else {
                    if (map.containsValue(tc)) return false;
                    map.put(sc, tc);
                }
            }
            return true;
        }
    }
    public static class UnitTest {
        @Test
        public void testIsomorphicStrings() {
            Solution s = new IsomorphicStrings().new Solution();
            assertEquals(s.isIsomorphic("abba", "abab"), false);
        }
    }
}

