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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        int level = 0;

        levelOrderTraversal(root, level, result);

        Collections.reverse(result);
        return result;
    }

    public void levelOrderTraversal(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (result.size() <= level) {
            List<Integer> subList = new ArrayList<>();
            result.add(subList);
        }

        result.get(level).add(root.val);
        levelOrderTraversal(root.left, level + 1, result);
        levelOrderTraversal(root.right, level + 1, result);
    }
}