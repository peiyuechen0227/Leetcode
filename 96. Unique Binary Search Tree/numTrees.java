class Solution {
    public int numTrees(int n) {
        // dp[i] represents the number of structurally unique BST of node n
        int[] dp = new int[n + 1];
        // Base case
        dp[0] = 1; // when root is null
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int root = 0; root < i; root++) {
                dp[i] += dp[root] * dp[i - root - 1];
            }
        }

        return dp[n];
    }
}