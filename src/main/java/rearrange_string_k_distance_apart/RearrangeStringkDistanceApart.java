package rearrange_string_k_distance_apart;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RearrangeStringkDistanceApart {
//    Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
//
//    All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
//
//    Example 1:
//
//    Input: s = "aabbcc", k = 3
//    Output: "abcabc"
//    Explanation: The same letters are at least distance 3 from each other.
//            Example 2:
//
//    Input: s = "aaabc", k = 3
//    Output: ""
//    Explanation: It is not possible to rearrange the string.
//    Example 3:
//
//    Input: s = "aaadbbcc", k = 2
//    Output: "abacabcd"
//    Explanation: The same letters are at least distance 2 from each other.

    // Insert your Solution class here
    class Solution {
        class Node {
            char c;
            int f;
            Node (char c, int f) {
                this.c = c;
                this.f = f;
            }
        }
        public String rearrangeString(String s, int k) {
            Node[] map = new Node[26];
            for (int i=0; i<s.length(); i++) {
                map[s.charAt(i)-'a'].f++;
            }
            for (int i=0; i<26; i++) {
                map[i].c = (char)('a' + i);
            }
            Arrays.sort(map, (a,b)->a.f-b.f);
            char[] res = new char[s.length()];
            int start = 0;
            int curIdx = start;
            for (int i=25; i>=0; i--) {
                while (map[i].f > 0) {
                    if (start >= k) return "";
                    res[curIdx] = map[i].c;
                    curIdx += k;
                    map[i].f--;
                    if (curIdx > s.length()-1) {
                        start++;
                        curIdx = start;
                    }
                }
            }

            return new String(res);
        }
    }
    public static class UnitTest {
        @Test
        public void testRearrangeStringkDistanceApart() {
            Solution s = new RearrangeStringkDistanceApart().new Solution();
        }
    }
}

