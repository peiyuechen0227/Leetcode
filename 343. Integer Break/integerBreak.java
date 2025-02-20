class Solution {
    public int integerBreak(int n) {
        // dp[i] represents the maximum product of i
        int[] dp = new int[n + 1];
        dp[2] = 1; // Base case

        for(int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                // Compute the maximum product
                // 1. Splitting i into j and i - j
                // 2. Splitting j and further breaking i - j into smaller parts
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}