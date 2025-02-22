class Solution {
    // Solution 1:
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int rows = matrix.length;
    //     int cols = matrix[0].length;

    //     for (int i = 0; i < rows; i++) {
    //         int left = 0;
    //         int right = cols - 1;
    //         while (left <= right) {
    //             int mid = left + (right - left) / 2;
    //             if (matrix[i][mid] == target) {
    //                 return true;
    //             } else if (matrix[i][mid] > target) {
    //                 right = mid - 1;
    //             } else left = mid + 1;
    //         }
    //     }
    //     return false;
    // }

    // Solution 2:
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else i++;
        }

        return false;
    }
}