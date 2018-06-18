package reorganize_string;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReorganizeString {

    // Insert your Solution class here
    class Solution {
        public String reorganizeString(String S) {
            int [] num = new int[26];
            for (int i=0; i<S.length(); i++) {
                num[S.charAt(i)-'a']++;
            }
            int max = 0;
            int maxC = -1;
            for (int i=0; i<26; i++) {
                if (num[i] > max) {
                    max = num[i];
                    maxC = i;
                }
            }
            return "";
        }
    }
    public static class UnitTest {
        @Test
        public void testReorganizeString() {
            Solution s = new ReorganizeString().new Solution();
        }
    }
}

