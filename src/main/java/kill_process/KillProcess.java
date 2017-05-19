package kill_process;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class KillProcess {

    /***
     Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

     Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

     We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

     Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
     */
    // Insert your Solution class here
    public class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
            for (int i=0; i<pid.size(); i++) {
                ArrayList<Integer> list = map.get(ppid.get(i));
                if (!map.containsKey(ppid.get(i))) {
                    list = new ArrayList<Integer>();
                    map.put(ppid.get(i), list);
                }
                list.add(pid.get(i));
            }
            ArrayList<Integer> res = new ArrayList<Integer>();
            Queue<Integer> q = new ArrayDeque<Integer>();
            q.add(kill);
            while (q.size() > 0) {
                int t = q.poll();
                res.add(t);
                if (map.containsKey(t)) {
                    q.addAll(map.get(t));
                }
            }
            return res;
        }
    }
    public static class UnitTest {
        @Test
        public void testKillProcess() {
            Solution s = new KillProcess().new Solution();
        }
    }
}

