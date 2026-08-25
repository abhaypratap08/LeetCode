// RECURSIVE APPROACH
// class Solution {
//     public int tribonacci(int n) {
//         if(n == 0) return 0;
//         else if(n == 1 || n == 2) return 1;
//         else return tribonacci(n-1) + tribonacci(n-2)+ tribonacci(n-3);
//     }
// }


// TOP-DOWN APPROACH (MEMOIZATION)
// class Solution {
//     public int tribonacci(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return fun(n, dp);
//     }
//     public int fun(int n, int[] dp){
//         if(n==0) return 0;
//         if(n == 1 || n==2 ) return 1;
//         if(dp[n] != -1) return dp[n];
//         dp[n] = fun(n-1, dp) + fun(n-2, dp) + fun(n-3, dp);
//         return dp[n];
//     }
// }

//BOTTOM-UP APPROACH (TABULIZATION)
class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}