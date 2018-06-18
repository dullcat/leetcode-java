package merge_intervals;

import java.util.*;

import common.Interval;
import org.junit.*;
import static org.junit.Assert.*;

public class MergeIntervals {

//    Given a collection of intervals, merge all overlapping intervals.
//
//    Example 1:
//
//    Input: [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//    Example 2:
//
//    Input: [[1,4],[4,5]]
//    Output: [[1,5]]
//    Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

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
        public List<Interval> merge(List<Interval> intervals) {
            Collections.sort(intervals, (a,b)-> a.start==b.start? a.end-b.end:a.start-b.start);
            List<Interval> res = new ArrayList<>();
            Interval cur = null;
            for(int i=0; i<intervals.size(); i++) {
                if (cur == null) {
                    cur = intervals.get(i);
                    continue;
                }
                if (cur.end < intervals.get(i).start) {
                    res.add(cur);
                    cur = intervals.get(i);
                }
                else {
                    cur.end = Math.max(cur.end, intervals.get(i).end);
                }
            }
            if (cur != null) res.add(cur);

            return res;
        }
    }

    // 95ms
    class Solution1 {
        public List<Interval> merge(List<Interval> intervals) {
            Collections.sort(intervals, (a,b)-> a.start-b.start);
            List<Interval> res = new ArrayList<>();
            Interval cur = null;
            for(int i=0; i<intervals.size(); i++) {
                if (cur == null) {
                    cur = intervals.get(i);
                    continue;
                }
                if (cur.end < intervals.get(i).start) {
                    res.add(cur);
                    cur = intervals.get(i);
                }
                else {
                    cur.end = Math.max(cur.end, intervals.get(i).end);
                }
            }
            if (cur != null) res.add(cur);

            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testMergeIntervals() {
            Solution s = new MergeIntervals().new Solution();
        }
    }
}

