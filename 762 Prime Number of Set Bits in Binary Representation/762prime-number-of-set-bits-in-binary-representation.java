class Solution {
    private static int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19};

    private int comb(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) return 0;

        long f1 = 1, f2 = 1;
        for (int i = k + 1; i <= n; i++) {
            f1 *= i;
        }

        for (int i = 2; i <= n - k; i++) {
            f2 *= i;
        }

        return (int) (f1 / f2);
    }

    private int countValid(int av, int al) {
        int count = 0;
        for (int prime : PRIMES) {
            int need = prime - al;
            if (need < 0 || need > av) {
                continue;
            }
            count += comb(av, need);
        }

        return count;
    }

    private int countPrimes(int num) {
        for (int i = PRIMES.length - 1; i >= 0; i--) {
            if (num >= PRIMES[i]) {
                return i + 1;
            }
        }
        return 0;
    }

    private int countNum(int num) {
        if (num == 0) return 0;

        int mask = 0x40000000;
        int pos = 31, curr = 0, total = 0;
        while (mask != 0) {
            if ((num & mask) != 0) {
                total += countValid(pos - 1, curr);
                curr++;
            }
            mask >>>= 1;
            pos--;
        }

        total += countPrimes(curr);
        return total;
    }

    public int countPrimeSetBits(int left, int right) {
        return countNum(right) - countNum(left - 1);
    }
}