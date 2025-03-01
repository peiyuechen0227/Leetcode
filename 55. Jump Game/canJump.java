class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        int furthest = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= furthest){
                dp[i] = true;
                furthest = i;
            }
        }
        return dp[0];
    }
}
