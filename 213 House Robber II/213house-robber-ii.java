// RECURSIVE APPROACH

// class Solution {

//     public int fun(int start, int end, int[] nums) {

//         if(start > end) return 0;

//         int s1 = nums[start] + fun(start + 2, end, nums);
//         int s0 = fun(start + 1, end, nums);

//         return Math.max(s0, s1);
//     }

//     public int rob(int[] nums) {

//         if(nums.length == 1) return nums[0];

//         int s1 = fun(0, nums.length - 2, nums);
//         int s0 = fun(1, nums.length - 1, nums);

//         return Math.max(s0, s1);
//     }

// }



// TOP-DOWN APPROACH (MEMOIZATION)

// class Solution {

//     public int fun(int start, int end, int[] nums, int[] dp) {

//         if(start > end) return 0;

//         if(dp[start] != -1) return dp[start];

//         int s1 = nums[start] + fun(start + 2, end, nums, dp);
//         int s0 = fun(start + 1, end, nums, dp);

//         return dp[start] = Math.max(s0, s1);
//     }

//     public int rob(int[] nums) {

//         if(nums.length == 1) return nums[0];

//         int[] dp1 = new int[nums.length];
//         int[] dp2 = new int[nums.length];

//         Arrays.fill(dp1, -1);
//         Arrays.fill(dp2, -1);

//         int s1 = fun(0, nums.length - 2, nums, dp1);
//         int s0 = fun(1, nums.length - 1, nums, dp2);

//         return Math.max(s0, s1);
//     }

// }



// BOTTOM-UP APPROACH (TABULIZATION)

class Solution {

    public int solve(int start, int end, int[] nums) {

        int[] dp = new int[nums.length];

        dp[start] = nums[start];

        if(start + 1 <= end) {
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        }

        for(int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];
    }

    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];

        int s1 = solve(0, nums.length - 2, nums);
        int s0 = solve(1, nums.length - 1, nums);

        return Math.max(s0, s1);
    }

}