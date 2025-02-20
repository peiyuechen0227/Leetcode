class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Edge case: empty matrix
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Flattening 2D matrix into 1D array
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Convert 1D index to 2D indices
            int mid_val = matrix[mid/cols][mid%cols];
            if (mid_val == target) {
                return true;
            } else if (mid_val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
