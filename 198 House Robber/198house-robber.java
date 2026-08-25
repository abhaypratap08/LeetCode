// RECURSIVE APPROACH
// class Solution {
//     public int fun(int n, int[] nums){
//         if(n >= nums.length) return 0;
//         int s1 = nums[n] + fun(n+2,nums);
//         int s0 = nums[n-1] + fun(n+2-1, nums);
//         return Math.max(s0, s1);
//     }

//     public int rob(int[] nums) {
//         return fun(1, nums);
//     }
// }


// TOP-DOWN APPROACH (MEMOIZATION)
// class Solution {
//     public int fun(int n, int[] nums, int[] dp) {
//         if(n >= nums.length) return 0;
//         if(dp[n] != -1) return dp[n];
//         int s0 = nums[n] + fun(n + 2, nums, dp);
//         int s1 = fun(n + 1, nums, dp);
//         return dp[n] = Math.max(s0, s1);
//     }

//     public int rob(int[] nums) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, -1);
//         return fun(0, nums, dp);
//     }
// }

// BOTTOM-UP APPROACH (TABULIZATION)
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}