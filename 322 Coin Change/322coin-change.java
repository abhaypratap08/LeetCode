// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if (amount < 0) return -1;
//         if (amount == 0) return 0;

//         int minCount = Integer.MAX_VALUE;

//         for (int coin : coins) {
//             int res = coinChange(coins, amount - coin);
//             if (res >= 0 && res < minCount) {
//                 minCount = 1 + res;
//             }
//         }

//         return (minCount == Integer.MAX_VALUE) ? -1 : minCount;
//     }
// }

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        // Fill with a value to indicate not computed yet
        Arrays.fill(memo, -2);
        return solve(coins, amount, memo);
    }

    private int solve(int[] coins, int rem, int[] memo) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (memo[rem] != -2) return memo[rem];

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(coins, rem - coin, memo);
            if (res >= 0 && res < minCount) {
                minCount = 1 + res;
            }
        }
        memo[rem] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        return memo[rem];
    }
}


