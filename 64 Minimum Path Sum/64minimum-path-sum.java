// RECURSION - 25/66 testcase

// class Solution {
//     public static int MAX = Integer.MAX_VALUE;
//     public int minPathSum(int[][] grid) {
//         return F(grid.length-1, grid[0].length-1, grid);
//     }

//     public int F(int i, int j, int[][] grid) {
//         if (i == 0 && j == 0)
//             return grid[i][j];
//         if (i < 0 || j < 0)
//             return MAX;
//         int up = F(i - 1, j, grid);
//         int left = F(i, j-1, grid);
//         return grid[i][j] + Math.min(up,left);
//     }
// }


//MEMOIZATION - all testcase pass 

class Solution {
    public static int MAX = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int r[] : dp){
            Arrays.fill(r, -1);
        }
        return F(grid.length-1, grid[0].length-1, grid, dp);
    }

    public int F(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return MAX;
        if(dp[i][j] != -1) return dp[i][j];
        int up = F(i - 1, j, grid, dp);
        int left = F(i, j-1, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(up,left);
    }
}