// RECURSIVE APPROACH
// class Solution {
//     public int fun(int i, int[] cost) {
//         if (i == 0) return 0;
//         if (i == 1) return 0;
//         int s1 = cost[i-1] + fun(i-1, cost);
//         int s2 = cost[i-2] + fun(i-2, cost);
//         return Math.min(s1, s2);
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         return fun(cost.length, cost);
//     }
// }


// TOP-DOWN APPROACH (MEMOIZATION)
class Solution {
    public int fun(int i, int[] cost, int[] dp) {
        if (i == 0) return 0;
        if (i == 1) return 0;
        if (dp[i] != -1 ) return dp[i];
        int s1 = cost[i-1] + fun(i-1, cost, dp);
        int s2 = cost[i-2] + fun(i-2, cost, dp);
        return dp[i] = Math.min(s1, s2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return fun(cost.length, cost, dp);
    }
}