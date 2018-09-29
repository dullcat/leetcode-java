package tiny_url;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TinyUrl {
//    Given a long url, make it shorter. To make it simpler, let's ignore the domain name.
//
//    You should implement two methods:
//
//    longToShort(url). Convert a long url to a short url.
//    shortToLong(url). Convert a short url to a long url starts with http://tiny.url/.
//    You can design any shorten algorithm, the judge only cares about two things:
//
//    The short key's length should equal to 6 (without domain and slash). And the acceptable characters are [a-zA-Z0-9]. For example: abcD9E
//    No two long urls mapping to the same short url and no two short urls mapping to the same long url.
//    Have you met this question in a real interview?
//    Example
//    Given url = http://www.lintcode.com/faq/?id=10, run the following code (or something similar):
//
//    short_url = longToShort(url) // may return http://tiny.url/abcD9E
//    long_url = shortToLong(short_url) // return http://www.lintcode.com/faq/?id=10
//    The short_url you return should be unique short url and start with http://tiny.url/ and 6 acceptable characters. For example "http://tiny.url/abcD9E" or something else.
//
//    The long_url should be http://www.lintcode.com/faq/?id=10 in this case.

    // Insert your Solution class here
    public class TinyUrl1 {
        Map<String, String> long2short;
        Map<String, String> short2long;
        String shortUrlPrefix = "http://tiny.url/";
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int len = 6;

        public TinyUrl1() {
            long2short = new HashMap();
            short2long = new HashMap();
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
            System.out.println(id);
            if (short2long.containsKey(id))
                return short2long.get(id);
            return "";
        }
    }
    public static class UnitTest {
        @Test
        public void testTinyUrl() {
            //Solution s = new TinyUrl().new Solution();
        }
    }
}

