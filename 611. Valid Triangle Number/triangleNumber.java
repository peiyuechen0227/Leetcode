import java.util.*;
public class triangleNumber {
    public int triangle(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        triangleNumber triangleNumber = new triangleNumber();
        System.out.println(triangleNumber.triangle(new int[]{2,2,3,4}));
    }
}
