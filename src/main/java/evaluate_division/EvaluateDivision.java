package evaluate_division;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EvaluateDivision {
//    Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
//
//    Example:
//    Given a / b = 2.0, b / c = 3.0.
//    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
//            return [6.0, 0.5, -1.0, 1.0, -1.0 ].
//
//    The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
//
//    According to the example above:
//
//    equations = [ ["a", "b"], ["b", "c"] ],
//    values = [2.0, 3.0],
//    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
//    The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
//

    // Insert your Solution class here
    class Solution {
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            Map<String, Map<String, Double>> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            double[] res = new double[queries.length];

            for (int i=0; i<equations.length; i++) {
                String key = equations[i][0];
                if (!map.containsKey(key)) {
                    map.put(key, new HashMap<String, Double>());
                }
                map.get(key).put(equations[i][1], values[i]);

                key = equations[i][1];
                if (!map.containsKey(key)) {
                    map.put(key, new HashMap<String, Double>());
                }
                map.get(key).put(equations[i][0], 1.0/values[i]);
            }

            for (int i=0; i<queries.length; i++) {
                res[i] = 1.0;
                set.clear();
                if (!map.containsKey(queries[i][0])) {
                    res[i] = -1.0;
                    continue;
                }
                if (queries[i][0].equals(queries[i][1])) {
                    continue;
                }
                if (!calc(queries[i][0], queries[i][1], map, set, res, i)) {
                    res[i] = -1.0;
                }
            }
            return res;
        }

        private boolean calc(String from, String to, Map<String, Map<String, Double>> map, Set<String> set, double[] res, int index) {
            if (!map.containsKey(from)) {
                return false;
            }
            set.add(from);
            for (String s : map.get(from).keySet()) {
                res[index] *= map.get(from).get(s);
                if (s.equals(to)) {
                    return true;
                }
                if (!set.contains(s)) {
                    if(calc(s, to, map, set, res, index))
                        return true;
                }
                res[index] /= map.get(from).get(s);
            }
            set.remove(from);
            return false;
        }
    }
    public static class UnitTest {
        @Test
        public void testEvaluateDivision() {
            Solution s = new EvaluateDivision().new Solution();
        }
    }
}

