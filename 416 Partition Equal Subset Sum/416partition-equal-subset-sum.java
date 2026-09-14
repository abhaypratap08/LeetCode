//Recursion - 39 / 149 testcase pass

// class Solution {
//     private int[][] dp;
//     public boolean canPartition(int[] nums) {
//         int total = 0;
//         for (int x : nums) total += x;
//         if ((total & 1) == 1) return false;
//         int target = total / 2;
//         return F(nums, target, nums.length - 1) == 1;
//     }

//     private int F(int[] nums, int sum, int idx) {
//         if (idx < 0 || sum < 0) return 0;
//         if (sum == nums[idx]) return 1;
//         return (F(nums, sum, idx - 1) == 1 || F(nums, sum - nums[idx], idx - 1) == 1) ? 1 : 0;
//     }
// }


//Memoization - all testcase pass

class Solution {
    private int[][] dp;
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        if ((total & 1) == 1) return false;
        int target = total / 2;
        dp = new int[target + 1][nums.length];
        for (int i = 0; i <= target; i++) Arrays.fill(dp[i], -1);
        return F(nums, target, nums.length - 1) == 1;
    }

    private int F(int[] nums, int sum, int idx) {
        if (idx < 0 || sum < 0) return 0;
        if (dp[sum][idx] != -1) return dp[sum][idx];
        if (sum == nums[idx]) return dp[sum][idx] = 1;
        dp[sum][idx] = (F(nums, sum, idx - 1) == 1 || F(nums, sum - nums[idx], idx - 1) == 1) ? 1 : 0;
        return dp[sum][idx];
    }
}