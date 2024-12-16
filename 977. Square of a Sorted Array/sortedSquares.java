class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] sortedSquare = new int[nums.length];
        int index = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        while (left <= right) {
            if (nums[left] > nums[right]) {
                sortedSquare[index] = nums[left];
                left++;
            }
            else {
                sortedSquare[index] = nums[right];
                right--;
            }
            index--;
        }
        return sortedSquare;

        // solution 2
        // int temp = 0;
        // for (int i = 0; i < nums.length; i++) {
        //      nums[i] = nums[i]*nums[i];
        // }
        // for (int j = nums.length - 1; j >= 0; j--) {
        //     for (int k = 0; k <= j - 1; k++) {
        //         if (nums[k] > nums[k+1]) {
        //             temp = nums[k+1];
        //             nums[k+1] = nums[k];
        //             nums[k] = temp;
        //         }
        //     }
        // }
        // return nums;
    }
}