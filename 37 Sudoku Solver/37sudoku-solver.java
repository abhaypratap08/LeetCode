class Solution {
    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];
    char[][] board;
    boolean sudokuSolved = false;

    public boolean CanBePlaced(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void PutNumber(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }

    public void removeNumber(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void PutNextNumbers(int row, int col) {
        if (row == N - 1 && col == N - 1) sudokuSolved = true;
        else if (col == N - 1) backtrack(row + 1, 0);
        else backtrack(row, col + 1);
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d <= 9; d++) {
                if (CanBePlaced(d, row, col)) {
                    PutNumber(d, row, col);
                    PutNextNumbers(row, col);
                    if (!sudokuSolved) removeNumber(d, row, col);
                }
            }
        } else PutNextNumbers(row, col);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] != '.') PutNumber(Character.getNumericValue(board[i][j]), i, j);
        backtrack(0, 0);
    }
}