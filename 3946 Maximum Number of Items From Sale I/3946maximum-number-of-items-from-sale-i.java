class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] eligible = new int[n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(i != j && items[j][0] % items[i][0] == 0)
                    eligible[i]++;

        int cheapest = Integer.MAX_VALUE;
        for(int[] it : items)
            cheapest = Math.min(cheapest, it[1]);

        int[][] dp = new int[budget + 1][2];
        for(int[] d : dp) Arrays.fill(d, -1);
        dp[0][0] = 0;
        dp[0][1] = 0;

        for(int i = 0; i < n; i++){
            int cost = items[i][1];
            int bonus = eligible[i];
            for(int c = budget; c >= cost; c--){
                if(dp[c - cost][0] >= 0){
                    int newFree = dp[c - cost][0] + bonus;
                    int newBought = dp[c - cost][1] + 1;
                    if(newFree > dp[c][0] || dp[c][0] < 0){
                        dp[c][0] = newFree;
                        dp[c][1] = newBought;
                    }
                }
            }
        }

        long ans = 0;
        for(int c = 0; c <= budget; c++){
            if(dp[c][0] < 0) continue;
            long val = dp[c][0] + dp[c][1] + (long)(budget - c) / cheapest;
            ans = Math.max(ans, val);
        }

        return (int) ans;
    }
}