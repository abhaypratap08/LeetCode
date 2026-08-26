// RECURSIVE APPROACH
// class Solution {
//     public int fib(int n) {
//         if(n==0||n==1) return n;
//         return fib(n-1)+fib(n-2);
//     }
// }

class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fun(n, dp);
    }
    public int fun(int n, int[] dp){
        if(n == 0 || n == 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fun(n-1, dp)+fun(n-2, dp);
    }
}
