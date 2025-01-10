import java.util.*;

// Definition for a binary tree node.
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    // Solution 1: Recursively invert a Binary Tree
    // public TreeNode invertTree(TreeNode root) {
    //     invert(root);
    //     return root;
    // }

    // // Recursive function to invert a Binary Tree
    // public void invert(TreeNode root) {
    //     if (root == null) {
    //         return; // Base Case: If the node is null, stop recursion
    //     }

    //     // invert the left and right child nodes of root
    //     TreeNode cur = root.left;
    //     root.left = root.right;
    //     root.right = cur;

    //     // Recursively invert the left and right subtrees
    //     invert(root.left);
    //     invert(root.right);
    // }

    // Solution 2: Use a queue
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // Use a queue to store each level of the tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Iterate each level to invert the tree
        while (!queue.isEmpty()) {
            // size of each level
            int size = queue.size();

            while (size > 0) {
                TreeNode cur = queue.poll();
                // Swap the left and right nodes of current node
                swap(cur);
                // Add its left and right nodes in the queue
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                size--;
            }
        }
        return root;
    }

    public void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;
    }
}
