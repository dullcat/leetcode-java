package can_place_flowers;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CanPlaceFlowers {
    // https://leetcode.com/contest/leetcode-weekly-contest-35/problems/can-place-flowers/
    /***
     * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
     * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
     */
    // Insert your Solution class here
    public class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int cur = 0;
            while (n>0 && cur <= flowerbed.length - 1) {
                if (flowerbed[cur] == 1) {
                    cur += 2;
                }
                else {
                    if ((cur == 0 || flowerbed[cur-1]==0) && (cur==flowerbed.length-1 || flowerbed[cur+1]==0)) {
                        cur += 2;
                        n--;
                    }
                    else {
                        cur++;
                    }
                }
            }

            return !(n>0);
        }
    }
    public static class UnitTest {
        @Test
        public void testCanPlaceFlowers() {
            Solution s = new CanPlaceFlowers().new Solution();
            assertEquals(true, s.canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
            assertEquals(false, s.canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
        }
    }
}

