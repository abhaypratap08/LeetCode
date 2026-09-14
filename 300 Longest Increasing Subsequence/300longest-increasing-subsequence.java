class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // Every element is an LIS of length 1 by itself
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        int maxLen = 1;
        
        // Build dp array
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        
        return maxLen;
    }
}