package unique_word_abbreviation;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class UniqueWordAbbreviation {

    // Insert your Solution class here
    class ValidWordAbbr {

        private Map<String, Integer> map;
        private Set<String> set;
        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap();
            set = new HashSet();
            for (String w: dictionary) {
                String abbrStr = AbbrWord(w);
                if (!set.contains(w) && map.containsKey(abbrStr))
                    map.put(abbrStr, 2);
                else
                    map.put(abbrStr, 1);
                set.add(w);
            }
        }

        public boolean isUnique(String word) {
            String abbr = AbbrWord(word);
            if (map.containsKey(abbr)) {
                if (set.contains(word) && (map.get(abbr)==1)) return true;
                return false;
            }
            return true;
        }

        private String AbbrWord(String word) {
            if (word == null || word.length() <= 2) return word;
            StringBuilder abbr = new StringBuilder();
            abbr.append(word.charAt(0));
            abbr.append(word.length()-2);
            abbr.append(word.charAt(word.length()-1));
            return abbr.toString();
        }
    }

    /**
     * Your ValidWordAbbr object will be instantiated and called as such:
     * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
     * boolean param_1 = obj.isUnique(word);
     */
    public static class UnitTest {
        @Test
        public void testUniqueWordAbbreviation() {
            //Solution s = new UniqueWordAbbreviation().new Solution();
            //String[] dict = {"deer","door","cake","card"};
            String[] dict = {"hello"};
            ValidWordAbbr s = new UniqueWordAbbreviation().new ValidWordAbbr(dict);
            assertEquals(s.isUnique("hello"), true);
            assertEquals(s.isUnique("cart"), true);
            int i = -1;
            assertEquals(i, i>>1);
        }
    }
}

