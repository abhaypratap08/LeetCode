class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0 || num == 1) return true;

        int lo = 1, hi = num;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sqr = (long) mid * mid;
            if (sqr == num) return true;
            else if (sqr > num) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
