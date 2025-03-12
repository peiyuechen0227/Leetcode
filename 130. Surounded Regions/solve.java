class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        // Find the edge O
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[n - 1][i] == 'O') {
                dfs(board, n - 1, i);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[j][0] == 'O') {
                dfs(board, j, 0);
            }
            if (board[j][m - 1] == 'O') {
                dfs(board, j, m - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'T';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}
