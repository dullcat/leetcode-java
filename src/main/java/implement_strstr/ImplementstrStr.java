package implement_strstr;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ImplementstrStr {

    // Insert your Solution class here
    public class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;

            int hLen = haystack.length();
            int nLen = needle.length();
            if (hLen < nLen) return -1;

            for (int i=0; i<hLen-(nLen-1); i++) {
                int j=0;
                for(j=0; j<nLen; j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == nLen) {
                    return i;
                }
            }
            return -1;
        }
    }
    public static class UnitTest {
        @Test
        public void testImplementstrStr() {
            Solution s = new ImplementstrStr().new Solution();
        }
    }
}

