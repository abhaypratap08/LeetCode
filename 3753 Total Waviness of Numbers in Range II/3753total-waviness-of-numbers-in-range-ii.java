class Solution {
    String s;
    long[][][][][][] dp;
    boolean[][][][][] vis;

    long[] solve(int idx, int pp, int p, int tight, int lead) {
        if (idx == s.length()) return new long[]{1, 0};

        if (vis[idx][pp][p][tight][lead]) {
            return new long[]{
                dp[idx][pp][p][tight][lead][0],
                dp[idx][pp][p][tight][lead][1]
            };
        }

        vis[idx][pp][p][tight][lead] = true;

        long cnt = 0;
        long wave = 0;

        int lim = tight == 1 ? s.charAt(idx) - '0' : 9;

        for (int d = 0; d <= lim; d++) {
            int ntight = (tight == 1 && d == lim) ? 1 : 0;
            int nlead = (lead == 1 && d == 0) ? 1 : 0;

            int np = nlead == 1 ? 10 : d;
            int npp = nlead == 1 ? 10 : (lead == 1 ? 10 : p);

            boolean wavy = false;
            if (pp != 10 && p != 10) {
                if ((pp < p && p > d) || (pp > p && p < d))
                    wavy = true;
            }

            long[] res = solve(idx + 1, npp, np, ntight, nlead);

            cnt += res[0];
            wave += res[1] + (wavy ? res[0] : 0);
        }

        dp[idx][pp][p][tight][lead][0] = cnt;
        dp[idx][pp][p][tight][lead][1] = wave;

        return new long[]{cnt, wave};
    }

    long calc(long num) {
        if (num < 100) return 0;

        s = Long.toString(num);

        dp = new long[18][11][11][2][2][2];
        vis = new boolean[18][11][11][2][2];

        return solve(0, 10, 10, 1, 1)[1];
    }

    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }
}