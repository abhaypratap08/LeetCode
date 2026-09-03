// Recursion - 38/64 testcase

// class Solution {
//     public int uniquePaths(int m, int n) {
//         return F(m-1,n-1);
//     }

//     public int F(int i, int j) {
//         if (i == 0 && j == 0)    //base case when F(0,0)
//             return 1;
//         if (i < 0 || j < 0)      //base case when either F(-1, j) OR F(i, -1) 
//             return 0;
//         int up = F(i - 1, j);
//         int left = F(i, j-1);
//         return up+left;
//     }
// }


// Memoization - 
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return F(m-1,n-1,dp);
    }

    public int F(int i, int j, int[][] dp) {
        if (i == 0 && j == 0)    //base case when F(0,0)
            return 1;
        if (i < 0 || j < 0)      //base case when either F(-1, j) OR F(i, -1) 
            return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int up = F(i - 1, j, dp);
        int left = F(i, j-1, dp);
        return dp[i][j] = up+left;
    }
}