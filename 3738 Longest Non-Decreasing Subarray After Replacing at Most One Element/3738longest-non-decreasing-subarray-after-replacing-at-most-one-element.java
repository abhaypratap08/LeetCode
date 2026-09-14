class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] serathion = nums;

        if (n == 1) return 1;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = serathion[i] >= serathion[i - 1] ? left[i - 1] + 1 : 1;
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = serathion[i] <= serathion[i + 1] ? right[i + 1] + 1 : 1;
        }

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, left[i]);
            if (i > 0) maxLen = Math.max(maxLen, left[i - 1] + 1);
            if (i < n - 1) maxLen = Math.max(maxLen, right[i + 1] + 1);
            if (i > 0 && i < n - 1 && serathion[i - 1] <= serathion[i + 1]) {
                maxLen = Math.max(maxLen, left[i - 1] + 1 + right[i + 1]);
            }
        }

        return maxLen;
    }
}
