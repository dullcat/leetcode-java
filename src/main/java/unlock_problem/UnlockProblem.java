package unlock_problem;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class UnlockProblem {

    // Insert your Solution class here
    public class Solution {
        /**
         * @param n: the number of keys
         * @param m: the number of locks
         * @return: the numbers of open locks
         */
        public int unlock(int n, int m) {
            // Write your code here
            int[] res = new int[m]; // 0 = open, 1 = locked
            for (int i=2; i<=n; i++) {
                for (int j=i; j<=m; j+=i) {
                    if (j % i == 0) {
                        res[j-1] = 1-res[j-1];
                    }
                }
            }

            int num = 0;
            for (int i=0; i<m; i++) num+=res[i];
            return m-num;
        }
    }
    public static class UnitTest {
        @Test
        public void testUnlockProblem() {
            Solution s = new UnlockProblem().new Solution();
        }
    }
}

