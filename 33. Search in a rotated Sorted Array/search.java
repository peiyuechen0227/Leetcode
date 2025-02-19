class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If target is found, return index
            if (nums[mid] == target) {
                return mid;
            }

            // If left intervel is ordered
            if (nums[left] <= nums[mid]) {
                // If target is in left intervel
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { // If target is not in left interval
                    left = mid + 1;
                }
            } else { // If right interval is ordered
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
