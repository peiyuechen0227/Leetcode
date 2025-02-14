class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combine(k, n, 1, 0);
        return result;
    }

    private void combine(int k, int n, int startIndex, int sum) {
        // If the combination has exactly k elements and the sum equals n, add it to the result list
        if (path.size() == k && sum == n) {
            result.add(new LinkedList<>(path)); // Create a new list to store the combination
            return;
        }

        // Iterate through numbers from startIndex to 9 (since we can only use 1-9)
        for (int i = startIndex; i <= 9; i++) {
            // Add the current number to the combination
            path.add(i);
            sum += i;

            // Proceed with the next number only if the sum does not exceed n
            if (sum <= n) {
                combine(k, n, i + 1, sum);
            }

            // Backtrack: remove the last added number and revert the sum
            sum -= i;
            path.removeLast();
        }
    }
}
