package design_compressed_string_iterator;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DesignCompressedStringIterator {

    // Insert your Solution class here
    public class StringIterator {
        char curLetter;
        int curCount = 0;
        int curIndex = 0;
        String s;

        public StringIterator(String compressedString) {
            s = compressedString;
            curCount = 0;
        }
        private void readNextLetter() {
            if (!isEmpty()) {
                curLetter = s.charAt(curIndex);
                curCount = 0;
                curIndex++;
                while (curIndex <= s.length()-1 && s.charAt(curIndex) >= '0' && s.charAt(curIndex) <= '9') {
                    curCount = curCount * 10 + s.charAt(curIndex) - '0';
                    curIndex++;
                }
            }

        }
        private boolean isEmpty() {
            return (s == null || s.isEmpty() || (curCount==0 && curIndex >= s.length()-1));
        }

        public char next() {
            if (isEmpty()) return ' ';
            if (curCount == 0) {
                readNextLetter();
            }
            curCount--;
            return curLetter;
        }

        public boolean hasNext() {
            return !isEmpty();
        }
    }

    public static class UnitTest {
        @Test
        public void testDesignCompressedStringIterator() {
            //Solution s = new DesignCompressedStringIterator().new Solution();
        }
    }
}

