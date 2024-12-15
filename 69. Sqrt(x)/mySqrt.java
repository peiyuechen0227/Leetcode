class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        int target = x;
        while (left <= right) {
            long mid = left + (right - left)/2;
            long sqrt = mid * mid;
            if (sqrt > target) {
                right = (long)mid - 1;
            }
            else if (sqrt < target) {
                left = (long)mid + 1;
            }
            else return (int)mid;
        }
        return (int)left - 1;
    }
}