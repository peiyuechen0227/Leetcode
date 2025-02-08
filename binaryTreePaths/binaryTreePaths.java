/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // Stores current traversal path
        List<Integer> path = new ArrayList<>();
        traversal(root, path, result);
        return result;
    }

    void traversal(TreeNode node, List<Integer> path, List<String> result) {
        path.add(node.val);
        // If node is a left node, construct the path and add to result
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }

        // Traverse left subtree if it exists
        if (node.left != null) {
            traversal(node.left, path, result);
            path.remove(path.size() - 1);
        }

        // Traverse right subtree if it exists
        if (node.right != null) {
            traversal(node.right, path, result);
            path.remove(path.size() - 1);
        }
    }
}
