package load_balancer;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class LoadBalancer {
//    Implement a load balancer for web servers. It provide the following functionality:
//
//    Add a new server to the cluster => add(server_id).
//    Remove a bad server from the cluster => remove(server_id).
//    Pick a server in the cluster randomly with equal probability => pick().
//    Have you met this question in a real interview?
//    Example
//        At beginning, the cluster is empty => {}.
//
//        add(1)
//        add(2)
//        add(3)
//        pick()
//    >> 1         // the return value is random, it can be either 1, 2, or 3.
//        pick()
//    >> 2
//        pick()
//    >> 1
//        pick()
//    >> 3
//        remove(1)
//        pick()
//    >> 2
//        pick()
//    >> 3
//        pick()
//    >> 3

    // Insert your Solution class here
    public class LoadBalancer1 {
        List<Integer> servers;
        Set<Integer> set;
        Random ran;
        public LoadBalancer1() {
            // do intialization if necessary
            servers = new ArrayList<>();
            set = new HashSet<>();
            ran = new Random();
        }

        /*
         * @param server_id: add a new server to the cluster
         * @return: nothing
         */
        public void add(int server_id) {
            // write your code here
            if (set.contains(server_id)) return;
            servers.add(server_id);
            set.add(server_id);
        }

        /*
         * @param server_id: server_id remove a bad server from the cluster
         * @return: nothing
         */
        public void remove(int server_id) {
            // write your code here
            set.remove(server_id);
            servers = new ArrayList<Integer>(set);
        }

        /*
         * @return: pick a server in the cluster randomly with equal probability
         */
        public int pick() {
            // write your code here
            int i = ran.nextInt(servers.size());
            return servers.get(i);
        }
    }    public static class UnitTest {
        @Test
        public void testLoadBalancer() {
            //Solution s = new LoadBalancer().new Solution();
        }
    }
}

