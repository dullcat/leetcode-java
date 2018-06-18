package excel_sheet_column_title;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ExcelSheetColumnTitle {
//    Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//    For example:
//
//            1 -> A
//    2 -> B
//    3 -> C
//    ...
//            26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//    Example 1:
//
//    Input: 1
//    Output: "A"
//    Example 2:
//
//    Input: 28
//    Output: "AB"
//    Example 3:
//
//    Input: 701
//    Output: "ZY"

    // Insert your Solution class here
    class Solution {
        public String convertToTitle(int n) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                sb.append((char)((n-1) % 26 + 'A'));
                n = (n-1)/26;
            }
            return sb.reverse().toString();
        }
    }
    public static class UnitTest {
        @Test
        public void testExcelSheetColumnTitle() {
            Solution s = new ExcelSheetColumnTitle().new Solution();
        }
    }
}

