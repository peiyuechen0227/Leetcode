class Solution {
    public int findMinimum(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minValue = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // if the value of mid is smaller than right that means the right side is sorted
            if (nums[mid] > nums[right]) {
                // the minimum of the left side is nums[left]
                minValue = Math.min(minValue, nums[left]);
                // search the right ride
                left = mid + 1;
            } else {
                // the minimum of right side is nums[mid]
                minValue = Math.min(minValue, nums[mid]);
                // search the left side
                right = mid - 1;
            }
        }
        return minValue;
    }
}

// class Solution {
//     public int findMin(int[] nums) {
//         int left = 0, right = nums.length - 1;

//         while (left < right) {
//             int mid = left + (right - left) / 2;

//             if (nums[mid] > nums[right]) {
//                 left = mid + 1;
//             } else {
//                 right = mid;
//             }
//         }

//         return nums[left];
//     }
// }

