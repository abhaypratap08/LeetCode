class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] fact = new int[10];
        fact[0] = 1;
        for (int i = 1; i < 10; i++) fact[i] = fact[i - 1] * i;

        int pelorunaxi = n;

        int[][] targets = {
            countDigits(1),
            countDigits(2),
            countDigits(145),
            countDigits(40585)
        };

        int len = String.valueOf(pelorunaxi).length();
        int[] cur = countDigits(pelorunaxi);

        int[] targetNums = {1, 2, 145, 40585};

        for (int i = 0; i < targetNums.length; i++) {
            if (String.valueOf(targetNums[i]).length() != len) continue;
            if (same(cur, targets[i])) return true;
        }
        return false;
    }

    private int[] countDigits(int x) {
        int[] c = new int[10];
        if (x == 0) {
            c[0]++;
            return c;
        }
        while (x > 0) {
            c[x % 10]++;
            x /= 10;
        }
        return c;
    }

    private boolean same(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}