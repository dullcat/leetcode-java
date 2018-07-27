package letter_combinations_of_a_phone_number;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LetterCombinationsofaPhoneNumber {
//    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//    Example:
//
//    Input: "23"
//    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//    Note:
//
//    Although the above answer is in lexicographical order, your answer could be in any order you want.

    // Insert your Solution class here
    class Solution {
        public List<String> letterCombinations(String digits) {
            String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            StringBuilder sb = new StringBuilder();
            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) return res;
            res.add("");
            for (int i=0; i<digits.length(); i++) {
                List<String> cur = new ArrayList<>();
                for (int j=0; j<res.size(); j++) {
                    for (char c: map[digits.charAt(i)-'0'].toCharArray()) {
                        cur.add(res.get(j)+c);
                    }
                }
                res = cur;
            }

            return res;
        }
    }
    class Solution1 {
        public List<String> letterCombinations(String digits) {
            String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            StringBuilder sb = new StringBuilder();
            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) return res;
            dfs(digits, map, 0, sb, res);

            return res;
        }

        private void dfs(String digits, String[] map, int index, StringBuilder cur, List<String> res) {
            if (index == digits.length()) {
                res.add(cur.toString());
                return;
            }
            for (char c: map[digits.charAt(index)-'0'].toCharArray()) {
                cur.append(c);
                dfs(digits, map, index+1, cur, res);
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }
    public static class UnitTest {
        @Test
        public void testLetterCombinationsofaPhoneNumber() {
            Solution s = new LetterCombinationsofaPhoneNumber().new Solution();
            List<String> r = s.letterCombinations("23");
        }
    }
}

