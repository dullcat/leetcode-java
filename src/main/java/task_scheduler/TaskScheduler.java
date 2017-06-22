package task_scheduler;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TaskScheduler {

    // Insert your Solution class here
    public class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];
            for (int i=0; i<tasks.length; i++) {
                count[tasks[i]-'A']++;
            }
            int max = -1;
            int maxCount = 0;
            for (int i=0; i<26; i++) {
                if (count[i] > max) {
                    max = count[i];
                    maxCount = 1;
                }
                else if (count[i] == max) {
                    maxCount++;
                }
            }
            int minLen = (max-1) * (n+1) + maxCount;
            int len = Math.max(tasks.length, minLen);
            return len;
        }
    }

    public static class UnitTest {
        @Test
        public void testTaskScheduler() {
            Solution s = new TaskScheduler().new Solution();
            Assert.assertEquals(8, s.leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
            Assert.assertEquals(10, s.leastInterval(new char[] {'A','A','A','B','B','B'}, 3));
        }
    }
}

