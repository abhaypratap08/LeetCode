class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k + 2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int l = 0 ; l < k + 2; l++ ){
                    dp[i][j][l] = -2;
                }
            }
        }
        int ans = DP(0, 0 , 0 , k , grid, dp);
        if(ans < 0){
            return -1;
        }
        return ans;
    }

    public int DP(int i , int j , int cost, int k , int[][] grid , int[][][] dp){
        if(i >= grid.length || j >= grid[0].length){
            return -1;
        }
        if(cost > k){
            return -1;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1){
            if(grid[i][j] != 0){
                cost++;
                if(cost > k) return -1;
            }
            return grid[i][j];
        }

        if(dp[i][j][cost] != -2){
            return dp[i][j][cost];
        }

        int right = -1;
        int down = -1;

        int newCost = cost + (grid[i][j] > 0 ? 1 : 0);
        int add = grid[i][j];

        if(j < grid[0].length - 1){
            right = DP(i, j + 1, newCost, k, grid, dp);
        }
        if(i < grid.length - 1){
            down = DP(i + 1, j, newCost, k, grid, dp);
        }

        int best = Math.max(right, down);
        if(best == -1){
            dp[i][j][cost] = -1;
        }else{
            dp[i][j][cost] = add + best;
        }

        return dp[i][j][cost];
    }
}
