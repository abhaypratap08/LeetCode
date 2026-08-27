// RECURSIVE APPROACH
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int max = 0;
//         for(int x : nums){
//             max = Math.max(x, max);
//         }
//         int[] sum = new int[max+1];
//         for(int x : nums){
//             sum[x] += x; 
//         }
//         return fun(0, sum);
//     }

//     public int fun(int n, int[] nums){
//         if(n >= nums.length) return 0;
//         int s0 = nums[n] + fun(n+2, nums);
//         int s1 = fun(n+1, nums);
//         return Math.max(s0,s1);
//     }
// }


// TOP-DOWN APPROACH (MEMOIZATION)
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int max = 0;
//         for(int x : nums){
//             max = Math.max(x, max);
//         }
//         int[] sum = new int[max+1];
//         for(int x : nums){
//             sum[x] += x; 
//         }
//         int[] dp = new int[max+1];
//         Arrays.fill(dp, -1);
//         return fun(0, sum, dp);
//     }

//     public int fun(int n, int[] nums, int[] dp){
//         if(n >= nums.length) return 0;
//         if(dp[n] != -1) return dp[n];
//         int s0 = nums[n] + fun(n+2, nums, dp);
//         int s1 = fun(n+1, nums, dp);
//         return dp[n] = Math.max(s0,s1);
//     }
// }


// BOTTOM-UP APPROACH (TABULIZATION)
class Solution {
     public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int x : nums) {
            max = Math.max(max, x);
        }
        int[] sum = new int[max + 1];
        for(int x : nums) {
            sum[x] += x;
        }
        int[] dp = new int[max + 1];
        if(max >= 1) {
            dp[1] = sum[1];
        }
        for(int i = 2; i <= max; i++) {
            int s1 = sum[i] + dp[i - 2];
            int s0 = dp[i - 1];
            dp[i] = Math.max(s0, s1);
        }
        return dp[max];
    }
}