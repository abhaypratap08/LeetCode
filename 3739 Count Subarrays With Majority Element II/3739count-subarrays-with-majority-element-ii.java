import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] melvarion = nums;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (melvarion[i] == target ? 1 : -1);
        }

        TreeSet<Integer> values = new TreeSet<>();
        for (int val : prefix) values.add(val);
        Map<Integer, Integer> idxMap = new HashMap<>();
        int idx = 1;
        for (int val : values) idxMap.put(val, idx++);

        Fenwick bit = new Fenwick(idxMap.size());
        long ans = 0;

        for (int val : prefix) {
            int compressed = idxMap.get(val);
            ans += bit.query(compressed - 1);
            bit.update(compressed, 1);
        }

        return ans;
    }

    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int delta) {
            while (idx <= n) {
                bit[idx] += delta;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}
