package find_area;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FindArea {

    // Insert your Solution class here

/*
Q1. Finding the area:  <Uber>
Given a robot that takes one simple instruction at a time. the input to the robot is a number X, the robot responds by taking X steps forward, turns left and waits for the next instruction.
The robot takes N such instructions.
Write a program to find the area of the smallest rectangle that covers the entire path traversed by the robot.
*/

    public class Solution {
        int findArea(int[] steps) {
            //
            if (steps == null || steps.length == 0)
                return 0;

            int bottom=0, left=0, top=0, right=0;
            int x = 0, y = 0;
            int dir = 0; // 0: up, 1: left, 2: down, 3: right
            for (int step: steps) {
                if (dir == 0) {
                    y += step;
                    if (y > top) {
                        top = y;
                    }
                }
                else if (dir == 1){
                    x -= step;
                    if (x < left) {
                        left = x;
                    }
                }
                else if (dir == 2) {
                    y -= step;
                    if (y < bottom) {
                        bottom = y;
                    }
                }
                else {
                    x += step;
                    if (x > right) {
                        right = x;
                    }

                }
                dir = (dir + 1) % 4;
            }
            return (right-left) * (top-bottom);
        }

//        public static void main(String args[] ) throws Exception {
//            /* Enter your code here. Input can be hardcoded. Print output to STDOUT */
//
//            Solution s = new Solution();
//            int steps[] = {1,2};
//            System.out.println(s.findArea(steps));
//            int steps1[] = {2};
//            System.out.println(s.findArea(steps1));
//        }
    }
    public static class UnitTest {
        @Test
        public void testFindArea() {
            Solution s = new FindArea().new Solution();
        }
    }
}

