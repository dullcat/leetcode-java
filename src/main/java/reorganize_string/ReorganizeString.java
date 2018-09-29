package reorganize_string;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReorganizeString {
//    Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
//
//    If possible, output any possible result.  If not possible, return the empty string.
//
//            Example 1:
//
//    Input: S = "aab"
//    Output: "aba"
//    Example 2:
//
//    Input: S = "aaab"
//    Output: ""
//    Note:
//
//    S will consist of lowercase letters and have length in range [1, 500].

    // Insert your Solution class here
    class Solution {
        class Node {
            char c;
            int f;
            Node(char c, int f) {
                this.c = c;
                this.f = f;
            }
        }
        public String reorganizeString(String S) {
            int[] map = new int[26];
            for (char c: S.toCharArray()) {
                map[c-'a']++;
                if (map[c-'a'] >(S.length()-1)/2+1) return "";
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->b.f-a.f);
            for (int i=0; i<26; i++) {
                if (map[i] > 0) {
                    Node n = new Node((char)('a' + i), map[i]);
                    pq.offer(n);
                }
            }

            StringBuilder sb = new StringBuilder();
            Node last = null;
            while (!pq.isEmpty()) {
                Node n = pq.poll();
                if (n == last) {
                    n = pq.poll();
                    pq.offer(last);
                }
                sb.append(n.c);
                n.f--;
                last = n;
                if (n.f > 0) {
                    pq.offer(n);
                }
            }
            return sb.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testReorganizeString() {
            Solution s = new ReorganizeString().new Solution();
        }
    }
}

