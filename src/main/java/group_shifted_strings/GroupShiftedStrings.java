package group_shifted_strings;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class GroupShiftedStrings {
//    Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
//
//            "abc" -> "bcd" -> ... -> "xyz"
//    Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
//
//            Example:
//
//    Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
//    Output:
//            [
//            ["abc","bcd","xyz"],
//            ["az","ba"],
//            ["acef"],
//            ["a","z"]
//            ]

    // Insert your Solution class here
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> map = new HashMap<>();
            List<List<String>> res = new ArrayList<List<String>>();

            for (String s: strings) {
                String key = getKey(s);
                //System.out.println(key);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(s);
            }

            for (String key: map.keySet()) {
                res.add(map.get(key));
            }
            return res;
        }

        private String getKey(String s) {
            int d = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (char c: s.toCharArray()) {
                int cur = c - 'a';
                cur = cur < d? cur - d + 26: cur-d;
                char newC = (char)('a' + cur);
                sb.append(newC);
            }
            return sb.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testGroupShiftedStrings() {
            Solution s = new GroupShiftedStrings().new Solution();
        }
    }
}

