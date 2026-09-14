//Recursion - 27/46 testcase pass

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int r = triangle.size();
//         int c = triangle.get(r - 1).size();
//         int ans = Integer.MAX_VALUE;
//         for (int i = 0; i < c; i++) {
//             ans = Math.min(ans, f(r - 1, i, triangle));
//         }
//         return ans;
//     }
    
//     private int f(int r, int c, List<List<Integer>> arr) {
//         if (r < 0 || c < 0 || c >= arr.get(r).size()) return 10001;
//         if (r == 0 && c == 0) return arr.get(0).get(0);
//         int left = f(r - 1, c - 1, arr);
//         int right = f(r - 1, c, arr);
//         return arr.get(r).get(c) + Math.min(left, right);
//     }
// }


// Memoization - all testcase pass

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int r = triangle.size();
        int c = triangle.get(r - 1).size();
        int[][] dp = new int[r][c];
        for (int[] row : dp) Arrays.fill(row, -1);
        if (r == 1 && c == 1) return triangle.get(0).get(0);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < c; i++) {
            ans = Math.min(ans, f(r - 1, i, triangle, dp));
        }
        return ans;
    }
    
    private int f(int r, int c, List<List<Integer>> arr, int[][] dp) {
        if (r < 0 || c < 0 || c >= arr.get(r).size()) return 10001;
        if (r == 0 && c == 0) return arr.get(0).get(0);
        if (dp[r][c] != -1) return dp[r][c];
        int left = f(r - 1, c - 1, arr, dp);
        int right = f(r - 1, c, arr, dp);       
        dp[r][c] = arr.get(r).get(c) + Math.min(left, right);
        return dp[r][c];
    }
}