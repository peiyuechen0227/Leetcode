// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length/2];
//     }
// }

class Solution {
    public int majorityElement(int[] nums) {
        // Initialize the candidate element and its count
        int count = 0, candidate = 0;

        // Iterate through the array to find the majority candidate
        for (int num: nums) {
            if (count == 0) {
                // If count is zero, update the candidate
                candidate = num;
            }
            // Increase count if current num matches candidate, otherwise decrease count
            if (candidate == num) {
                count++;
            } else count--;
        }

        return candidate;
    }
}
