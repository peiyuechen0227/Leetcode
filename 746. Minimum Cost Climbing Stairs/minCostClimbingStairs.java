class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] represents the minimum cost to reach i-th stair
        // int[] dp = new int[cost.length + 1];

        // no need to cost from the ground
        // dp[0] = 0;
        // dp[1] = 0;

        // Iterate to calculate the minimum cost of each stair
        // for (int i = 2; i < dp.length; i++) {
        //     dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        // }
        // return dp[dp.length - 1];

        int a = 0; // dp[i - 1]
        int b = 0; // dp[i - 2]
        int c = 0; // dp[i]
        for (int i = 2; i < cost.length + 1; i++) {
            c = Math.min(b + cost[i - 1], a + cost[i - 2]);
            a = b;
            b = c;
        }

        return c;
    }
}
