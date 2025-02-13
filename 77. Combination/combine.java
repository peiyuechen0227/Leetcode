class Solution {
    // Store the final list of all valid combinations
    List<List<Integer>> result = new ArrayList<>();
    // Temporary list to store the current combination
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    private void backtracking(int n, int k, int startIndex) {
        // If the current combination size reaches k, add it to the result list
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Iterate over numbers from startIndex to n
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            // Choose the current number
            path.add(i);
            // Move to the next number in the sequence
            backtracking(n, k, i + 1);
            // Backtrack: remove the last added number to explore other possibilities
            path.removeLast();
        }

    }
}
