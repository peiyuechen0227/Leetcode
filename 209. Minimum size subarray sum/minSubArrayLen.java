class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int subL = Integer.MAX_VALUE;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum >= target) {
                subL = Math.min(subL, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return subL == Integer.MAX_VALUE ? 0 : subL;
    }
}