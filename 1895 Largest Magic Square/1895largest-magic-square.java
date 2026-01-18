class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int side = Math.min(m, n);
        while(side > 1){
            for(int i = 0; i < m - side + 1; i++){
                for(int j = 0; j < n - side + 1; j++){
                    if(isValid(grid, i, j, side)){
                        return side;
                    }
                }
            }
            side--;
        }
        return 1;
    }

    public boolean isValid(int[][] grid, int si, int sj, int side){
        int target = 0;

        for(int k = 0; k < side; k++){
            target += grid[si + k][sj + k];
        }

        int sum = 0;
        for(int k = 0; k < side; k++){
            sum += grid[si + k][sj + side - k - 1];
        }
        if(sum != target) return false;

        for(int i = si; i < si + side; i++){
            sum = 0;
            for(int j = sj; j < sj + side; j++){
                sum += grid[i][j];
            }
            if(sum != target) return false;
        }

        for(int j = sj; j < sj + side; j++){
            sum = 0;
            for(int i = si; i < si + side; i++){
                sum += grid[i][j];
            }
            if(sum != target) return false;
        }

        return true;
    }
}