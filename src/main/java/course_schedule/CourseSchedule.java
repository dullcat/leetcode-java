package course_schedule;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CourseSchedule {

    // Insert your Solution class here
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int finished = 0;
            Map<Integer, Set<Integer>> depended = new HashMap<>();
            int[] inDegree = new int[numCourses];

            for (int i=0; i<numCourses; i++) {
                depended.put(i, new HashSet<Integer>());
            }
            for (int i=0; i<prerequisites.length; i++) {
                depended.get(prerequisites[i][1]).add(prerequisites[i][0]);
                inDegree[prerequisites[i][0]]++;
            }

            LinkedList<Integer> zeroOuts = new LinkedList<Integer>();

            for (int i=0; i<numCourses; i++) {
                if (inDegree[i] == 0) {
                    zeroOuts.add(i);
                }
            }

            while (zeroOuts.size() > 0) {
                int cur = zeroOuts.poll();
                finished++;
                for (int i: depended.get(cur)) {
                    inDegree[i]--;
                    if (inDegree[i] == 0)
                        zeroOuts.add(i);
                }
            }
            return finished==numCourses;

        }
    }
    class Solution1 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int finished = 0;
            Map<Integer, Set<Integer>> depends = new HashMap<>();
            Map<Integer, Set<Integer>> depended = new HashMap<>();
            for (int i=0; i<numCourses; i++) {
                depends.put(i, new HashSet<Integer>());
                depended.put(i, new HashSet<Integer>());
            }
            for (int i=0; i<prerequisites.length; i++) {
                depends.get(prerequisites[i][0]).add(prerequisites[i][1]);
                depended.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            LinkedList<Integer> zeroOuts = new LinkedList<Integer>();

            for (int i=0; i<numCourses; i++) {
                if (depends.get(i).size() == 0) {
                    zeroOuts.add(i);
                }
            }

            while (zeroOuts.size() > 0) {
                int cur = zeroOuts.poll();
                finished++;
                for (int i: depended.get(cur)) {
                    depends.get(i).remove(cur);
                    if (depends.get(i).size() == 0)
                        zeroOuts.add(i);
                }
            }
            return finished==numCourses;

        }
    }
    public static class UnitTest {
        @Test
        public void testCourseSchedule() {
            Solution s = new CourseSchedule().new Solution();
        }
    }
}

