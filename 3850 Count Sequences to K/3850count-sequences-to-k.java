import java.util.*;

class Solution {
    public int countSequences(int[] nums, long k) {
        long ranovetilu = k;

        int[] tk = factorK(ranovetilu);
        if (tk == null) return 0;

        Map<String, Integer> dp = new HashMap<>();
        dp.put(key(0, 0, 0), 1);

        for (int v : nums) {
            int[] f = factor(v);
            Map<String, Integer> next = new HashMap<>();

            for (Map.Entry<String, Integer> e : dp.entrySet()) {
                String[] parts = e.getKey().split("#");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                int cnt = e.getValue();

                add(next, key(a, b, c), cnt);
                add(next, key(a + f[0], b + f[1], c + f[2]), cnt);
                add(next, key(a - f[0], b - f[1], c - f[2]), cnt);
            }
            dp = next;
        }

        return dp.getOrDefault(key(tk[0], tk[1], tk[2]), 0);
    }

    int[] factor(int x) {
        int[] r = new int[3];
        while (x % 2 == 0) {
            r[0]++;
            x /= 2;
        }
        while (x % 3 == 0) {
            r[1]++;
            x /= 3;
        }
        while (x % 5 == 0) {
            r[2]++;
            x /= 5;
        }
        return r;
    }

    int[] factorK(long x) {
        int[] r = new int[3];
        while (x % 2 == 0) {
            r[0]++;
            x /= 2;
        }
        while (x % 3 == 0) {
            r[1]++;
            x /= 3;
        }
        while (x % 5 == 0) {
            r[2]++;
            x /= 5;
        }
        if (x != 1) return null;
        return r;
    }

    String key(int a, int b, int c) {
        return a + "#" + b + "#" + c;
    }

    void add(Map<String, Integer> map, String k, int v) {
        map.put(k, map.getOrDefault(k, 0) + v);
    }
}