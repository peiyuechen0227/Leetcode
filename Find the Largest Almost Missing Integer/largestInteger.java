class Solution {
    public int largestInteger(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        int[] frequency = new int[51];


        while (right < nums.length) {
            HashSet<Integer> uniqueInWindow = new HashSet<>();

            for (int i = left; i <= right; i++) {
                uniqueInWindow.add(nums[i]);
            }

            for (int num : uniqueInWindow) {
                frequency[num]++;
            }
            left++;
            right++;
        }


        int result = -1;
        int minValue = nums.length - k + 1;
        for (int i = 50; i >= 0; i--) {
            if (frequency[i] == 1){
                result = i;
                break;
            }
        }

        return result;
    }
}