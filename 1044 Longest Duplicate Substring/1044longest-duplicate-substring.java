class SuffixArray {
    private int[] sa, lcp;
    private String s;

    SuffixArray(String s) {
        this.s = s;
        this.sa = buildSA(this.s);
        this.lcp = buildLCP(this.s, this.sa);
    }

    int[] getSA() {
        return this.sa;
    }

    int[] getLCP() {
        return this.lcp;
    }

    private void countSort(int k, int[] sa, int[] ra) {
        int n = sa.length, N = n + 256;
        int[] nsa = new int[n], cnt = new int[N];
        System.arraycopy(sa, 0, nsa, 0, n);
        for (int i = 0; i < n; i++) {
            cnt[ra[i]]++;
            nsa[i] = (nsa[i] - k + n) % n;
        }
        for (int i = 1; i < N; i++) cnt[i] += cnt[i - 1];
        for (int i = n - 1; i >= 0; i--) sa[--cnt[ra[nsa[i]]]] = nsa[i];
    }

    private int[] buildSAUTIL(String s) {
        int n = s.length();
        int[] sa = new int[n], ra = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = i;
            ra[i] = s.charAt(i);
        }
        for (int k = 0; k < n; k = k != 0 ? k << 1 : k + 1) {
            int[] nra = new int[n];
            countSort(k, sa, ra);
            int r = 0;
            for (int i = 1; i < n; i++) {
                if (ra[sa[i]] != ra[sa[i - 1]] || ra[(sa[i] + k) % n] != ra[(sa[i - 1] + k) % n]) r++;
                nra[sa[i]] = r;
            }
            ra = nra;
        }
        return sa;
    }

    private int[] buildSA(String s) {
        s += '@';
        int[] sa = buildSAUTIL(s);
        return Arrays.copyOfRange(sa, 1, sa.length);
    }

    private int[] buildLCP(String s, int[] sa) {
        int n = s.length(), k = 0;
        int[] lcp = new int[n - 1], ra = new int[n];
        for (int i = 0; i < n; i++) ra[sa[i]] = i;
        for (int i = 0; i < n; i++) {
            if (ra[i] == n - 1) {
                k = 0;
                continue;
            }
            int j = sa[ra[i] + 1];
            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) k++;
            lcp[ra[i]] = k;
            if (k > 0) k--;
        }
        return lcp;
    }
}

class Solution {
    private String getLRS(String s) {
        int max = 0, start = 0, end = 0;
        int n = s.length();
        SuffixArray array = new SuffixArray(s);
        int[] sa = array.getSA(), lcp = array.getLCP();
        for (int i = 0; i < n - 1; i++) {
            int len = lcp[i];
            if (len > max) {
                max = len;
                start = sa[i];
                end = sa[i] + len;
            }
        }
        return s.substring(start, end);
    }

    public String longestDupSubstring(String s) {
        return s.isEmpty() ? "" : getLRS(s);
    }
}