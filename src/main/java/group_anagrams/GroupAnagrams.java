package group_anagrams;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class GroupAnagrams {
//    Given an array of strings, group anagrams together.
//
//            Example:
//
//    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//    Output:
//            [
//            ["ate","eat","tea"],
//            ["nat","tan"],
//            ["bat"]
//            ]
//    Note:
//
//    All inputs will be in lowercase.
//    The order of your output does not matter.

    // Insert your Solution class here
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String s: strs) {
                String key = getKey(s);
                if (!map.containsKey(key))
                    map.put(key, new ArrayList<String>());
                map.get(key).add(s);
            }

            for (String s: map.keySet()) {
                res.add(map.get(s));
            }
            return res;
        }
        private String getKey(String s) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            return new String(str);
        }
    }
    public static class UnitTest {
        @Test
        public void testGroupAnagrams() {
            Solution s = new GroupAnagrams().new Solution();
        }
    }
}

