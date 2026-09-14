class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int next = i + brainpower + 1;
            long solve = points + dp[Math.min(next, n)];
            long skip = dp[i + 1];
            dp[i] = Math.max(solve, skip);
        }
        return dp[0];
    }
}