import java.util.*;

// Recursion - TLE

// class Solution {

//     private static final int MOD = 1_000_000_007;

//     public int distinctSubseqII(String s) {
//         return F(s, s.length());
//     }

//     private int F(String s, int n) {

//         if (n == 0) return 0;
//         if (n == 1) return 1;

//         int previousIndex = n - 2;

//         while (previousIndex >= 0 &&
//                s.charAt(previousIndex) != s.charAt(n - 1)) {
//             previousIndex--;
//         }

//         long total = (2L * F(s, n - 1)) % MOD;

//         if (previousIndex == -1) {
//             return (int) ((total + 1) % MOD);
//         }

//         return (int) ((total - F(s, previousIndex) + MOD) % MOD);
//     }
// }

// Memoization - All Test Cases Pass

class Solution {

private static final int MOD = 1_000_000_007;
private int[] dp;

public int distinctSubseqII(String s) {

    int n = s.length();

    dp = new int[n + 1];
    Arrays.fill(dp, -1);

    return F(s, n);
}

private int F(String s, int n) {

    if (n == 0) return 0;
    if (n == 1) return 1;

    if (dp[n] != -1) {
        return dp[n];
    }

    int previousIndex = n - 2;

    while (previousIndex >= 0 &&
           s.charAt(previousIndex) != s.charAt(n - 1)) {
        previousIndex--;
    }

    long total = (2L * F(s, n - 1)) % MOD;

    if (previousIndex == -1) {
        return dp[n] = (int) ((total + 1) % MOD);
    }
    return dp[n] = (int) ((total - F(s, previousIndex) + MOD) % MOD);
}
}