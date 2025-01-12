class Solution {
    public int maxDepth(Node root) {

        return getDepth(root);
    }

    public int getDepth(Node node) {
        // Base case: if node is null, it's an empty tree, return 0
        if (node == null) {
            return 0;
        }

        int maxDepth = 0;
        // Iterate its child nodes. get the depth of child nodes
        for (Node child: node.children) {
            maxDepth = Math.max(maxDepth, getDepth(child));
        }

        // return the largest depth
        return 1 + maxDepth;

    }
}