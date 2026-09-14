import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n]; 
        boolean[] d2 = new boolean[2 * n]; 
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, n, board, cols, d1, d2, result);
        return result;
    }
    private void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] d1, boolean[] d2, List<List<String>> result) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) solution.add(new String(r));
            result.add(solution);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (cols[col] || d1[row + col] || d2[row - col + n]) continue;
            board[row][col] = 'Q';
            cols[col] = d1[row + col] = d2[row - col + n] = true;
            backtrack(row + 1, n, board, cols, d1, d2, result);
            board[row][col] = '.';
            cols[col] = d1[row + col] = d2[row - col + n] = false;
        }
    }
}