class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> nums = new ArrayList<>();
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 0;
        int loop = 1;
        int i, j;


        while (loop <= Math.min(m, n)/2) {
            for (j = startY; j < n - offset; j++) {
                nums.add(matrix[startX][j]);
            }

            for (i = startX; i < m - offset; i++) {
                nums.add(matrix[i][j]);
            }

            for (j = n - offset; j > startY; j--) {
                nums.add(matrix[i][j]);
            }

            for (i = m - offset; i > startX; i--) {
                nums.add(matrix[i][j]);
            }

            startX++;
            startY++;
            offset++;
            loop++;
        }

        if (Math.min(m, n)%2 == 1) {
            if (m > n) {
                for (i = offset - 1; i <= m - offset; i++) {
                    nums.add(matrix[i][n/2]);
                }
            }
            else {
                for (j = offset - 1; j <= n - offset; j++) {
                    nums.add(matrix[m/2][j]);
                }
            }
        }
        return nums;
    }
}