package oa_closest_x_destinations;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class OAClosestXdestinations {

    // Insert your Solution class here
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
    // CLASS BEGINS, THIS CLASS IS REQUIRED
    public class Solution
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        List<List<Integer>> ClosestXdestinations(int numDestinations,
                                                 List<List<Integer>> allLocations,
                                                 int numDeliveries)
        {
            // WRITE YOUR CODE HERE
            PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    long d1 = o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1);
                    long d2 = o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1);
                    return (int)(d1-d2);
                }
            });

            for (List<Integer> location: allLocations) {
                pq.offer(location);
            }

            List<List<Integer>> res = new ArrayList<>();
            for (int i=0; i<numDeliveries; i++) {
                res.add(pq.poll());
            }

            return res;
        }
        // METHOD SIGNATURE ENDS
    }
    public static class UnitTest {
        @Test
        public void testOAClosestXdestinations() {
            Solution s = new OAClosestXdestinations().new Solution();
        }
    }
}

