class Solution {
    // public int countPairs(List<Integer> nums, int target) {
    //     nums.sort(null);
    //     int left = 0;
    //     int right = nums.size() - 1;
    //     int result = 0;

    //     while (left < right) {
    //         int sum = nums.get(left) + nums.get(right);
    //         while (left < right && sum >= target) {
    //             right--;
    //             sum = nums.get(left) + nums.get(right);
    //         }

    //         if (left < right) {
    //             result += right - left;
    //         }

    //         left++;
    //     }
    //     return result;
    // }

    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }
}
