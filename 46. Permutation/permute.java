import java.util.*;
class Solution {
    // Store the result
    List<List<Integer>> result = new ArrayList<>();
    // Store current permutation through iteration
    LinkedList<Integer> path = new LinkedList<>();
    // Mark if the element is used in the recursion or not
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        //used[i] = false;
        backtracking(nums, used);
        return result;
    }

    // backtrack to find all the permutations
    void backtracking(int[] nums, boolean[] used) {
        // if the path.length is equal to nums.length, means all elements have been permute
        if(path.size() == nums.length) {
            // Add current path to result
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // if nums[i] is used, skip current element
            if (used[i]) {
                continue;
            }
            // Else, add to path
            path.add(nums[i]);
            used[i] = true;
            // backtrack to find the next element
            backtracking(nums, used);
            // Remove the last one
            path.removeLast();
            // Set used to bo unused
            used[i] = false;
        }
        return;
    }
}
// Time complexity: O(n!) n of factorial
// Space complexity: O(n)