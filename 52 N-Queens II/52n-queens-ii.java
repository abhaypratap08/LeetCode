class Solution {
    int count = 0;
    int[] arr;
    public int totalNQueens(int n) {
        arr = new int[n];
        helper(0, n);
        return count;
    }
    private void helper(int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                arr[row] = col;
                helper(row + 1, n);
            }
        }
    }
    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == col || Math.abs(row - i) == Math.abs(col - arr[i]))
                return false;
        }
        return true;
    }
}