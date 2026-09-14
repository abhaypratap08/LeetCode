class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] memo = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                memo[n]++;
            } else {
                memo[citation]++;
            }
        }
        for (int h = n - 1; h >= 0; h--) {
            memo[h] += memo[h + 1];
        }
        for (int h = n; h >= 0; h--) {
            if (memo[h] >= h) {
                return h;
            }
        }
        return 0;
    }
}