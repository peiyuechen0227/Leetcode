/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    Node dfs(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node clone = new Node(node.val);
        map.put(node.val, clone);
        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }
        return clone;
    }
}
