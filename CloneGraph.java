
// Definition for a Node.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        HashMap<Node, Node> visited = new HashMap();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        while (!queue.isEmpty()) {
            Node n = queue.remove(); //node
            for (Node neighbor : n.neighbors) { 
                if (!visited.containsKey(neighbor)) { 
                    visited.put(
                        neighbor,
                        new Node(neighbor.val, new ArrayList())
                    );
                    queue.add(neighbor); 
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}