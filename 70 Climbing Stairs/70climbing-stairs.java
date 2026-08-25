// RECURSIVE APPROACH
// TC : O(n)
// class Solution {
//     public int climbStairs(int n) {
//         if(n <= 1) return 1;
//         if(n == 2) return 2;
//         int s1 = climbStairs(n-1);
//         int s2 = climbStairs(n-2);

//         return s1+s2;
//     }
// }


// TOP-DOWN APPROACH (MEMOIZATION)
// TC : O(n)
// SC : O(n)
// class Solution{
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return fun(n, dp);
//     }

//     public int fun(int n, int[] dp){
//         if(n == 0 || n == 1) return 1;
// 		if(dp[n] != -1) return dp[n];
// 		dp[n] = fun(n-1, dp) + fun(n-2, dp);
// 		return dp[n];
//     }
// }


// BOTTOM-UP APPROACH (TABULIZATION)
// TC : O(n)
// SC : O(n)
class Solution{
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<n+1; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}