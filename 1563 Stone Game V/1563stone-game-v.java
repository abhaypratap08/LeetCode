class Solution {
    public int stoneGameV(int[] stoneValue) {
        int totalSum = 0;
        int n = stoneValue.length;

        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return helper(0, n-1, stoneValue, dp);
    }

    private int helper(int left, int right, int[] stoneValue, int[][] dp){
        if(left == right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int totalSum = 0;

        for(int i=left;i<=right;i++){
            totalSum += stoneValue[i];
        }

        int leftSum = 0;
        int rightSum = 0;

        int maxScore = 0;

        for(int i=left;i<=right-1;i++){
            leftSum += stoneValue[i];
            rightSum = totalSum-leftSum;
            
            if(leftSum == rightSum){
                int l = leftSum + helper(i+1, right, stoneValue, dp);
                int r = rightSum + helper(left, i, stoneValue, dp);
                maxScore = Math.max(maxScore, Math.max(l, r));
            }
            else if(leftSum < rightSum){
                maxScore = Math.max(maxScore ,leftSum+helper(left, i, stoneValue, dp));
            }
            else{
                maxScore = Math.max(maxScore, rightSum + helper(i+1, right, stoneValue, dp));
            }
        }
        
        return dp[left][right] = maxScore;
    }
}