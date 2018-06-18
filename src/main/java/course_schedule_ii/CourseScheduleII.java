package course_schedule_ii;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CourseScheduleII {

    // Insert your Solution class here
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> depended = new HashMap<>();
            int[] inDegree = new int[numCourses];
            for (int i=0; i<numCourses; i++) {
                depended.put(i, new HashSet<Integer>());
            }

            for (int i=0; i<prerequisites.length; i++) {
                depended.get(prerequisites[i][1]).add(prerequisites[i][0]);
                inDegree[prerequisites[i][0]]++;
            }

            LinkedList<Integer> zeroIns = new LinkedList<Integer>();
            for (int i=0; i<numCourses; i++) {
                if (inDegree[i] == 0) {
                    zeroIns.add(i);
                }
            }

            List<Integer> res = new ArrayList<Integer>();
            while (!zeroIns.isEmpty()) {
                int cur = zeroIns.poll();
                res.add(cur);
                for (int i: depended.get(cur)) {
                    if (--inDegree[i] == 0) {
                        zeroIns.offer(i);
                    }
                }
            }

            int[] resa = new int[numCourses];
            int idx = 0;
            for (int i: res) {
                resa[idx++] = i;
            }
            if (res.size() == numCourses)
                return resa;
            else
                return new int[]{};
        }
    }
    public static class UnitTest {
        @Test
        public void testCourseScheduleII() {
            Solution s = new CourseScheduleII().new Solution();
        }
    }
}

