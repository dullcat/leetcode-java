package add_bold_tag_in_string;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class AddBoldTaginString {

    // Insert your Solution class here
    public class Solution {
        public String addBoldTag(String s, String[] dict) {
            if (s == null || s.isEmpty() || dict.length == 0) return s;
            boolean[] mark = new boolean[s.length()];
            for (String w : dict) {
                int startIndex = 0;
                while (true) {
                    int foundIndex = s.indexOf(w, startIndex);
                    if (foundIndex < 0) break;
                    for (int i=0; i<w.length(); i++) {
                        mark[foundIndex+i] = true;
                    }
                    startIndex = foundIndex + 1;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<mark.length;) {
                while (i < mark.length && !mark[i]) {
                    sb.append(s.charAt(i));
                    i++;
                }
                if (i >= mark.length) break;
                sb.append("<b>");
                while (i < mark.length && mark[i]) {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append("</b>");
                if (i >= mark.length) break;
            }

            return sb.toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testAddBoldTaginString() {
            Solution s = new AddBoldTaginString().new Solution();
            assertEquals("<b>abc</b>xyz<b>123</b>", s.addBoldTag("abcxyz123", new String[] {"abc","123"}));
            assertEquals("<b>aaabbc</b>c", s.addBoldTag("aaabbcc", new String[] {"aaa","aab","bc"}));
        }
    }
}

