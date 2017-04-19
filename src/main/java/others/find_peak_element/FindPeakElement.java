package others.find_peak_element;

public class FindPeakElement {

    public class Solution {
        public int findPeakElement(int[] num) {
            assert num.length != 0;
            for (int i = 0; i < num.length - 1; i++) {
                if (num[i] > num[i + 1]) {
                    return i;
                }
            }
            return num.length - 1;
        }
    }

    public static class UnitTest {

    }
}

