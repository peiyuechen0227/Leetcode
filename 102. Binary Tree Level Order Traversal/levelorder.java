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
    // Solution 1: Iteration
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     // Use a Doubly List to store the level order
    //     List<List<Integer>> result = new ArrayList<>();

    //     if (root == null) {
    //         return result;
    //     }

    //     // Use a queue to iterate the tree
    //     Queue<TreeNode> queue = new LinkedList<>();

    //     queue.add(root);

    //     while (!queue.isEmpty()) {
    //         // Use a List to store each level of the tree
    //         List<Integer> subResult = new ArrayList<>();

    //         // Size of the queue
    //         int size = queue.size();

    //         while (size > 0) {
    //             TreeNode cur = queue.poll();
    //             subResult.add(cur.val);
    //             if (cur.left != null) {
    //                 queue.add(cur.left);
    //             }
    //             if (cur.right != null) {
    //                 queue.add(cur.right);
    //             }
    //             size--;
    //         }

    //         result.add(subResult);
    //     }
    //     return result;
    // }

    // Solution 2: Recursion
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        int level = 0;

        levelOrderTraversal(root, level, result);

        return result;
    }

    public void levelOrderTraversal(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        if (result.size() <= level) {
            List<Integer> subList = new ArrayList<>();
            result.add(subList);
        }

        result.get(level).add(node.val);

        levelOrderTraversal(node.left, level + 1, result);

        levelOrderTraversal(node.right, level + 1, result);
    }
}