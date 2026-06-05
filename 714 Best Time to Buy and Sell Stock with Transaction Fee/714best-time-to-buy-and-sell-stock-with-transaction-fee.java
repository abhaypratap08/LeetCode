class Solution 
{
    public int maxProfit(int[] prices, int fee) 
    {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0; // profit on day 0 with no stock
        dp[0][1] = -prices[0]; // profit on day 0 with one stock

        for (int i = 1; i < n; i++) 
        {
            // Case 1: Sell the stock
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            
            // Case 2: Buy the stock
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}