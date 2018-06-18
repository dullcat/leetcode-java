package moving_average_from_data_stream;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MovingAveragefromDataStream {

//    346. Moving Average from Data Stream
//    Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
//    For example,
//    MovingAverage m = new MovingAverage(3);
//    m.next(1) = 1
//    m.next(10) = (1 + 10) / 2
//    m.next(3) = (1 + 10 + 3) / 3
//    m.next(5) = (10 + 3 + 5) / 3

    // Insert your Solution class here
    class MovingAverage {

        int size;
        int sum;
        LinkedList<Integer> q = new LinkedList<Integer>();
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            this.sum = 0;
        }

        public double next(int val) {
            q.add(val);
            if (q.size() > size) {
                sum -= q.poll();
            }
            sum += val;
            return (double) sum / q.size();
        }
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */

    public static class UnitTest {
        @Test
        public void testMovingAveragefromDataStream() {
            //Solution s = new MovingAveragefromDataStream().new Solution();

        }
    }
}

