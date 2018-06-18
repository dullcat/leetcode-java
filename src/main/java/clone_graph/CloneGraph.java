package clone_graph;

import java.util.*;

import common.UndirectedGraphNode;
import org.junit.*;
import static org.junit.Assert.*;

public class CloneGraph {

    // Insert your Solution class here
    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     List<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */
    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            HashMap<Integer, UndirectedGraphNode> map = new HashMap();
            return sub(node, map);
        }

        private UndirectedGraphNode sub(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
            if (node == null) return null;
            if (map.containsKey(node.label)) return map.get(node.label);

            UndirectedGraphNode n = new UndirectedGraphNode(node.label);
            map.put(node.label, n);
            for (UndirectedGraphNode nn: node.neighbors) {
                n.neighbors.add(sub(nn, map));
            }
            return n;
        }
    }
    public static class UnitTest {
        @Test
        public void testCloneGraph() {
            Solution s = new CloneGraph().new Solution();
        }
    }
}

