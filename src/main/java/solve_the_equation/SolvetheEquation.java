package solve_the_equation;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SolvetheEquation {

    // Insert your Solution class here
    public class Solution {
        public class Expression {
            int c1;
            int c0;
        }
        public String solveEquation(String equation) {
            String NoSolution = "No solution";
            String InfiniteSolutions = "Infinite solutions";

            String[] sides = equation.split("=");
            if (sides.length < 2) return NoSolution;
            Expression left = parseExp(sides[0]);
            Expression right = parseExp(sides[1]);
            left.c1 -= right.c1;
            left.c0 -= right.c0;
            if (left.c1 == 0 && left.c0 == 0) return InfiniteSolutions;
            if (left.c1 == 0 && left.c0 != 0) return NoSolution;
            return "x=" + (- left.c0 / left.c1);
        }

        Expression parseExp(String s) {
            Expression res = new Expression();
            int sign = 1;
            for (int i=0; i<s.length();) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    sign = s.charAt(i) == '-'? -1:1;
                    i++;
                }
                int cur = i;
                while (cur < s.length() && s.charAt(cur) >= '0' && s.charAt(cur) <= '9') cur++;
                if (cur == s.length() || s.charAt(cur) == '+' || s.charAt(cur) == '-') {
                    res.c0 += sign * Integer.parseInt(s.substring(i, cur));
                    i = cur;
                }
                else if (cur < s.length() && s.charAt(cur) == 'x') {
                    res.c1 += sign * (cur == i? 1:Integer.parseInt(s.substring(i, cur)));
                    i = cur + 1;
                }
            }
            return res;
        }

    }
    public static class UnitTest {
        @Test
        public void testSolvetheEquation() {
            Solution s = new SolvetheEquation().new Solution();
            assertEquals("x=2", s.solveEquation("x+5-3+x=6+x-2"));
            assertEquals("x=0", s.solveEquation("2x=x"));
        }
    }
}

