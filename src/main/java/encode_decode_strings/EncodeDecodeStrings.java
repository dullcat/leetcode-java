package encode_decode_strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    // Insert your Solution class here

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

    class Solution {
        String encode(List<String> strings) {
            if (strings == null || strings.size() == 0) return "";
            StringBuilder res = new StringBuilder();
            char[] clen = new char[3];

            for (String s: strings) {
                if (s == null) continue;
                int len = s.length();
                clen[2] = (char)(len % 10 + (int)'0');
                len /= 10;
                clen[1] = (char)(len % 10 + (int)'0');
                len /= 10;
                clen[0] = (char)(len % 10 + (int)'0');

                res.append(clen);
                res.append(s);
            }

            return res.toString();
        }

        List<String> decode(String str) {
            if (str == null || str.length() == 0) return null;
            ArrayList<String> res = new ArrayList<String>();

            int i = 0;
            while (i < str.length()) {

                String slen = str.substring(i,i+3);
                //System.out.println(slen);

                int len = Integer.parseInt(slen);
                //System.out.println(len);

                String s = str.substring(i+3, i+3+len);
                res.add(s);
                i = i + len + 3;
                //System.out.println(s);

            }
            if (i != str.length()) return null;

            return res;
        }
    }


    public static class UnitTest {
        @Test
        public void testEncodeDecodeStrings() {
            Solution s = new EncodeDecodeStrings().new Solution();
            ArrayList<String> strings = new ArrayList<String>();
            strings.add("H");
            strings.add("Welcome to CoderPad.");
            strings.add("This pad is running Java 8.");

            for (String string : strings) {
                System.out.println(string);
            }


            String fullStr = s.encode(strings);
            System.out.println(fullStr);

            List<String> decStrs = s.decode(fullStr);
            for (String string : decStrs) {
                System.out.println(string);
            }

        }
    }
}

