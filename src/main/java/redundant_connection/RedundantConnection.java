package redundant_connection;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RedundantConnection {

    // Insert your Solution class here

    // UF wih map
    class Solution1 {
        public int[] findRedundantConnection(int[][] edges) {
            Map<Integer, Integer> uf = new HashMap();
            for (int i=0; i<edges.length; i++) {
                if (!uf.containsKey(edges[i][0])) {
                    uf.put(edges[i][0],edges[i][0]);
                }
                if (!uf.containsKey(edges[i][1])) {
                    uf.put(edges[i][1],edges[i][1]);
                }
            }

            // union
            for (int i=0; i<edges.length; i++) {
                if (find(edges[i][0], uf) == find(edges[i][1], uf)) {
                    return edges[i];
                }
                else {
                    union(edges[i][0], edges[i][1], uf);
                }
            }

            return null;
        }
        int find(int point, Map<Integer, Integer> map) {
            int parent = map.get(point);
            while (point != map.get(point)) {
                point = parent;
                parent = map.get(point);
            }
            return parent;
        }
        void union(int p1, int p2, Map<Integer, Integer> map) {
            int parent1 = find(p1, map);
            int parent2 = find(p2, map);
            map.put(parent2, parent1);
        }
    }

    // uf with array
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int[] uf = new int[2000];
            for (int i=0; i<edges.length; i++) {
                uf[i] = i;
            }

            // union
            for (int i=0; i<edges.length; i++) {
                if (find(edges[i][0], uf) == find(edges[i][1], uf)) {
                    return edges[i];
                }
                else {
                    union(edges[i][0], edges[i][1], uf);
                }
            }

            return null;
        }
        int find(int point, int[] uf) {
            while (point != uf[point]) {
                uf[point] = uf[uf[point]];
                point = uf[point];
            }
            return point;
        }
        void union(int p1, int p2, int[] uf) {
            int parent1 = find(p1, uf);
            int parent2 = find(p2, uf);
            uf[parent1] = uf[parent2];
        }
    }

    public static class UnitTest {
        @Test
        public void testRedundantConnection() {
            Solution s = new RedundantConnection().new Solution();
        }
    }
}

