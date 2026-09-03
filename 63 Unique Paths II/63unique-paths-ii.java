// RECURSION - 30/42 testcase pass

// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         return F(m - 1, n - 1, obstacleGrid);
//     }
    
//     private int F(int i, int j, int[][] grid) {
//         if (i < 0 || j < 0) return 0;
//         if (grid[i][j] == 1) return 0;
//         if (i == 0 && j == 0) return 1;
//         int up = F(i - 1, j, grid);
//         int left = F(i, j - 1, grid);
//         return up + left;
//     }
// }


//Memoization - 

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return countPaths(m - 1, n - 1, obstacleGrid, dp);
    }

    private int countPaths(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (grid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int up = countPaths(i - 1, j, grid, dp);
        int left = countPaths(i, j - 1, grid, dp);
        return dp[i][j] = up + left;
    }
}