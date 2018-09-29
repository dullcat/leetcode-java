package meeting_rooms_ii;

import java.util.*;

import common.Interval;
import org.junit.*;
import static org.junit.Assert.*;

public class MeetingRoomsII {
//    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//    Example 1:
//
//    Input: [[0, 30],[5, 10],[15, 20]]
//    Output: 2
//    Example 2:
//
//    Input: [[7,10],[2,4]]
//    Output: 1

    // Insert your Solution class here
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class Solution {
        public int minMeetingRooms(Interval[] intervals) {
            int[][] p = new int[intervals.length*2][2];
            int i = 0;
            for (Interval interval: intervals) {
                p[i][0] = interval.start;
                p[i++][1] = 1;
                p[i++][0] = interval.end;
            }
            Arrays.sort(p, (a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
            int max = 0;
            int cur = 0;
            for (int[] pos: p) {
                if (pos[1] == 1) {
                    cur++;
                    max = Math.max(max, cur);
                }
                else {
                    cur--;
                }
            }
            return max;
        }
    }
    public static class UnitTest {
        @Test
        public void testMeetingRoomsII() {
            Solution s = new MeetingRoomsII().new Solution();
        }
    }
}

