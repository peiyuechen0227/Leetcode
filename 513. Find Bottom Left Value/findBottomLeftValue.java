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
    public int findBottomLeftValue(TreeNode root) {
        // Initialize a queue to store the nodes in every level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // Store the leftmost value
        int val = 0;
        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                // Dequeue the current node
                TreeNode cur = queue.poll();
                // Update the value when processing the first node in every level
                if (i == 0) {
                    val = cur.val;
                }

                //// Enqueue the left and right children if they exist
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return val;
    }
}
