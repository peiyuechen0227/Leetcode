import java.util.*;

class Solution {
    // Global variable to store all valid subsequences
    List<List<Integer>> result = new ArrayList<>();
    // Temporary list to store the current subsequence during backtracking
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    void backtracking(int[] nums, int startIndex) {
        // If the current sequence has at least two elements, add it to the result
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        // Base case: if we have reached the end of the array, return
        if (startIndex == nums.length) {
            return;
        }

        // Set to track used elements at the current recursion level to avoid duplicates
        HashSet<Integer> used = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
            // Pruning conditions:
            // 1. Ensure non-decreasing order: if the current number is smaller than the last one in the sequence, skip it
            // 2. Avoid duplicate numbers in the same recursion level to prevent duplicate subsequences
            if ((!path.isEmpty() && nums[i] < path.getLast()) || used.contains(nums[i])) {
                continue;
            }

            // Mark the current number as used in this recursion level
            used.add(nums[i]);
            // Add the current number to the path
            path.add(nums[i]);
            // Recur with the next index
            backtracking(nums, i + 1);
            // Backtrack: remove the last added number to explore other possibilities
            path.removeLast();
        }
    }
}

