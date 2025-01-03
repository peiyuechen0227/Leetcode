import java.util.*;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        if (target > 0 && result >= target) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (right > left && sum > target) {
                    result = sum - target > Math.abs(result - target) ? result : sum;
                    right--;
                } else if (right > left && sum < target) {
                    result = target - sum > Math.abs(result - target) ? result : sum;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSumClosest solution = new threeSumClosest();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
