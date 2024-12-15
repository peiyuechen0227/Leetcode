class Solution {
    public int[] searchRange(int[] nums, int target) {
        int rightBorder = getRightborder(nums, target);
        int leftBorder = getLeftborder(nums, target);
        if(rightBorder == -2 || leftBorder == -2){
            return new int[] {-1,-1};
        }
        if(rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        return new int[]{-1, -1};
    }

    int getRightborder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    int getLeftborder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                right = mid - 1;
                leftBorder = right;
            }
            else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }
}