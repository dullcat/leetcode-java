package rectangle_area;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RectangleArea {
//    Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//    Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//
//    Rectangle Area
//
//    Example:
//
//    Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
//    Output: 45
//    Note:
//
//    Assume that the total area is never beyond the maximum possible value of int.

    // Insert your Solution class here
    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int inL = Math.max(A, E);
            int inR = Math.min(C, G);
            int inB = Math.max(B, F);
            int inT = Math.min(D, H);
            int inArea = 0;
            if (inL < inR && inB < inT)
                inArea = (inR-inL) * (inT-inB);
            return (C-A)*(D-B) + (G-E)*(H-F) - inArea;
        }
    }
    public static class UnitTest {
        @Test
        public void testRectangleArea() {
            Solution s = new RectangleArea().new Solution();
        }
    }
}

