import java.util.*;


//RECURSION

// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         return f(0, 0, nums, target);
//     }

//     public int f(int i, int sum, int[] nums, int target) {
//         if (i == nums.length) {
//             if(sum == target) return 1; 
//             else return 0;
//         }

//         int plus = f(i + 1, sum + nums[i], nums, target);
//         int minus = f(i + 1, sum - nums[i], nums, target);

//         return plus + minus;
//     }
// }



//MEMOIZATION

// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int total = 0;
//         for (int x : nums) total += x;
//         if (Math.abs(target) > total) return 0;
//         int[][] dp = new int[nums.length][2 * total + 1];
//         for (int[] r : dp) Arrays.fill(r, -1);  
//         return f(0, 0, nums, target, dp, total);
//     }

//     public int f(int i, int sum, int[] nums, int target, int[][] dp, int offset) {
//         if (i == nums.length) return sum == target ? 1 : 0; 
//         int index = sum + offset;
//         if (dp[i][index] != -1) return dp[i][index];
//         int plus = f(i + 1, sum + nums[i], nums, target, dp, offset);
//         int minus = f(i + 1, sum - nums[i], nums, target, dp, offset);
//         return dp[i][index] = plus + minus;
//     }
// }


//TABULATION

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for (int x : nums) {
            total += x;
        }

        if (Math.abs(target) > total) {
            return 0;
        }

        int offset = total;
        int[][] dp = new int[nums.length + 1][2 * total + 1];

        dp[0][offset] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int sum = -total; sum <= total; sum++) {
                int ways = dp[i][sum + offset];

                if (ways == 0) {
                    continue;
                }

                dp[i + 1][sum + nums[i] + offset] += ways;
                dp[i + 1][sum - nums[i] + offset] += ways;
            }
        }

        return dp[nums.length][target + offset];
    }
}