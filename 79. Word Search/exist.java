class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, visited, word, 1, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean dfs(char[][] board, boolean[][] visited, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length || visited[nextX][nextY]) {
                continue;
            }

            if (board[nextX][nextY] == word.charAt(index) && dfs(board, visited, word, index + 1, nextX, nextY)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(solution.exist(board, word));
    }
}