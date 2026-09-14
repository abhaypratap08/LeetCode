// RECURSION
// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         return fun(0, -1, 0, nums);
//     }
//     boolean fun(int index, int prev, int count, int[] nums) {
//         if(count == 3) return true;
//         if(index == nums.length) return false;
//         boolean skip = fun(index + 1, prev, count, nums);
//         boolean take = false;
//         if(prev == -1 || nums[index] > nums[prev]) {
//             take = fun(index + 1, index, count + 1, nums);
//         }
//         return skip || take;
//     }
// }


//memoization
// import java.util.Arrays;
// class Solution {
//     int[][][] dp;
//     public boolean increasingTriplet(int[] nums) {
//         int n = nums.length;
//         dp = new int[n][n + 1][3];
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j <= n; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }
//         return fun(0, -1, 0, nums);
//     }
//     boolean fun(int index, int prev, int count, int[] nums) {
//         if(count == 3) return true;
//         if(index == nums.length) return false;
//         if(dp[index][prev + 1][count] != -1) {
//             return dp[index][prev + 1][count] == 1;
//         }
//         boolean skip = fun(index + 1, prev, count, nums);
//         boolean take = false;
//         if(prev == -1 || nums[index] > nums[prev]) {
//             take = fun(index + 1, index, count + 1, nums);
//         }
//         boolean ans = skip || take;
//         dp[index][prev + 1][count] = ans ? 1 : 0;
//         return ans;
//     }
// }


//tabulation
// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         int n = nums.length;
//         boolean[][][] dp = new boolean[n + 1][n + 1][4];
//         for(int index = 0; index <= n; index++) {
//             for(int prev = -1; prev < n; prev++) {
//                 dp[index][prev + 1][3] = true;
//             }
//         }
//         for(int index = n - 1; index >= 0; index--) {
//             for(int prev = -1; prev < index; prev++) {
//                 for(int count = 2; count >= 0; count--) {
//                     boolean skip = dp[index + 1][prev + 1][count];
//                     boolean take = false;
//                     if(prev == -1 || nums[index] > nums[prev]) {
//                         take = dp[index + 1][index + 1][count + 1];
//                     }
//                     dp[index][prev + 1][count] = skip || take;
//                 }
//             }
//         }
//         return dp[0][0][0];
//     }
// }

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] dp = new int[4];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int num : nums) {
            if(num <= dp[1]) {
                dp[1] = num;
            } else if(num <= dp[2]) {
                dp[2] = num;
            } else {
                return true;
            }
        }
        return false;
    }
}