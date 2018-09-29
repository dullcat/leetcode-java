package tiny_url_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TinyUrlII {
//    As a follow up for Tiny URL, we are going to support custom tiny url, so that user can create their own tiny url.
//
//    Custom url may have more than 6 characters in path.
//
//    Have you met this question in a real interview?
//    Example
//        createCustom("http://www.lintcode.com/", "lccode")
//    >> http://tiny.url/lccode
//        createCustom("http://www.lintcode.com/", "lc")
//    >> error
//        longToShort("http://www.lintcode.com/problem/")
//    >> http://tiny.url/1Ab38c   // this is just an example, you can have you own 6 characters.
//        shortToLong("http://tiny.url/lccode")
//    >> http://www.lintcode.com/
//        shortToLong("http://tiny.url/1Ab38c")
//    >> http://www.lintcode.com/problem/
//        shortToLong("http://tiny.url/1Ab38d")
//    >> null

    // Insert your Solution class here
    public class TinyUrl2 {
        Map<String, String> long2short;
        Map<String, String> short2long;
        String shortUrlPrefix = "http://tiny.url/";
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int len = 6;

        public TinyUrl2() {
            long2short = new HashMap();
            short2long = new HashMap();
        }

        /*
         * @param long_url: a long url
         * @param key: a short key
         * @return: a short url starts with http://tiny.url/
         */
        public String createCustom(String long_url, String key) {
            // write your code here
            if (key == null || key.length() != 6) return "error";
            if (short2long.containsKey(key) && short2long.get(key).equals(long_url))
                return shortUrlPrefix + key;
            if (short2long.containsKey(key) && !short2long.get(key).equals(long_url))
                return "error";
            if (long2short.containsKey(long_url) && !long2short.get(long_url).equals(key))
                return "error";

            short2long.put(key, long_url);
            long2short.put(long_url, key);
            return shortUrlPrefix + key;
        }

        String createRandomId() {
            StringBuilder sb = new StringBuilder();
            Random r = new Random();
            for (int i=0; i<len; i++) {
                int idx = r.nextInt(62);
                sb.append(charSet.charAt(idx));
            }
            return sb.toString();
        }
        /*
         * @param url: a long url
         * @return: a short url starts with http://tiny.url/
         */
        public String longToShort(String url) {
            // write your code here
            if (long2short.containsKey(url))
                return shortUrlPrefix + long2short.get(url);

            String shortId = createRandomId();
            while (short2long.containsKey(shortId)) {
                shortId = createRandomId();
            }
            long2short.put(url, shortId);
            short2long.put(shortId, url);
            return shortUrlPrefix + shortId;
        }

        /*
         * @param url: a short url starts with http://tiny.url/
         * @return: a long url
         */
        public String shortToLong(String url) {
            // write your code here
            String id = url.substring(shortUrlPrefix.length());
            //System.out.println(id);
            if (short2long.containsKey(id))
                return short2long.get(id);
            return "error";
        }
    }
    public static class UnitTest {
        @Test
        public void testTinyUrlII() {
            //Solution s = new TinyUrlII().new Solution();
        }
    }
}

