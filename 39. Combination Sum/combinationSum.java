class Solution {
    // Initialize a list to store the result
    List<List<Integer>> result = new ArrayList<>();
    // Store the path through recursion
    List<Integer> path = new ArrayList<>();
    // Variable to track the sum of the current combination
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    void backtracking(int[] candidates, int target, int startIndex) {
        // if sum matches target, add path to result and return
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Iterate through candidates, allow repeated numbers
        for (int i = startIndex; i < candidates.length; i++) {
            // Pruning: if adding the current number exceeds the target, stop exploring further
            if (sum + candidates[i] > target) {
                return;
            }

            // Include the current candidate in the combination
            path.add(candidates[i]);
            sum += candidates[i];
            // Recursively explore further with the same index (allowing duplicate selections)
            backtracking(candidates, target, i);
            // Backtrack: remove the last added number to explore other possibilities
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
