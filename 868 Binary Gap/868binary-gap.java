class Solution {
    public int binaryGap(int n) {
        if ((n & (n - 1)) == 0) return 0;
        n >>= Integer.numberOfTrailingZeros(n);
        int maxGap = 0, gap = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                maxGap = Math.max(maxGap, gap);
                gap = 0;
            } else
                gap++;
            n >>= 1;
        }

        return maxGap + 1;
    }
}