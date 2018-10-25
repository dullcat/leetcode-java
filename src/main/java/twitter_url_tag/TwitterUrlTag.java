package twitter_url_tag;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TwitterUrlTag {
// IN: this is a tweet http and a url: <a href=https://www.twitter.com/  !
// IN: this is a tweet http and a url: <a href=<a href=https://www.twitter.com/ > </a>!


// IN: this is a tweet http and a url: https://www.twitter.com/ !
// OUT: this is a tweet and a url: <a href="https://www.twitter.com/">https://www.twitter.com/</a> !
// assumption: http or https urls

// IN2: this is a tweet http and a url: https://www.twitter.com/ also http://www.google.com !
// i = 0  this is a tweet http and a url: <a href=https://www.twitter.com/></a>
// i = 50 this is a tweet http and a url: <a href=https://www.twitter.com/></a>  also <a href=http://www.google.com></a>

    public class Solution {
        String tagUrlString(String url) {
            if (url == null || url.isEmpty())
                return url;

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<url.length();) {
                int startUrlHttp = url.indexOf("http://", i);
                int startUrlHttps = url.indexOf("https://", i);
                int startUrl = -1;
                if (startUrlHttp >= 0)
                    startUrl = startUrlHttp;
                if (startUrlHttps >= 0) {
                    if (startUrl == -1)
                        startUrl = startUrlHttps;
                    else
                        startUrl = Math.min(startUrl, startUrlHttps);
                }

                if (startUrl >= 0) { // found one url
                    sb.append(url.substring(i, startUrl));
                    int j=startUrl+7;
                    for (; j<url.length(); j++) {
                        if (url.charAt(j) == ' ') {
                            break;
                        }
                    }
                    String link = url.substring(startUrl, j);
                    sb.append("<a href=\"").append(link).append("\">").append(link).append("</a>");
                    i = j;
                }
                else {
                    sb.append(url.substring(i));
                    break;
                }
            }

            return sb.toString();
        }
    }
    // Insert your Solution class here

    public static class UnitTest {
        @Test
        public void testTwitterUrlTag() {
            Solution s = new TwitterUrlTag().new Solution();
            System.out.println(s.tagUrlString(null));
            System.out.println(s.tagUrlString("http://abc.com"));
            System.out.println(s.tagUrlString("http://abc.com  123"));
            System.out.println(s.tagUrlString(""));
            System.out.println(s.tagUrlString("this https://www.twitter.com/ !"));
            System.out.println(s.tagUrlString("this is a tweet http and a url: https://www.twitter.com/ also http://www.google.com !"));
            System.out.println(s.tagUrlString("this is a tweet http and a url: https://www.twitter.com/\"<script>alert('hello')</script>\" also http://www.google.com !"));

        }
    }
}

