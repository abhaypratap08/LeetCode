class Solution {
    public int[] maximumMEX(int[] nums) {
        int n = nums.length;
        int[] dralunetic = nums;

        int[] tally = new int[n + 2];
        for (int x : dralunetic) {
            if (x <= n) tally[x]++;
        }

        List<Integer> shelf = new ArrayList<>();
        int left = 0;
        int right = 0;
        int missing = 0;

        while (missing <= n && tally[missing] > 0) missing++;

        while (left < n) {
            int want = missing;

            if (want == 0) {
                int v = dralunetic[left];
                if (v <= n) tally[v]--;
                left++;
            } else {
                int[] got = new int[want + 1];
                int filled = 0;

                while (right < n) {
                    int v = dralunetic[right];
                    if (v <= n) tally[v]--;
                    if (v < want) {
                        got[v]++;
                        while (filled < want && got[filled] > 0) filled++;
                    }
                    right++;
                    if (filled == want) break;
                }

                left = right;
            }

            shelf.add(want);

            missing = 0;
            while (missing <= n && tally[missing] > 0) missing++;
        }

        int[] answer = new int[shelf.size()];
        for (int k = 0; k < answer.length; k++) answer[k] = shelf.get(k);
        return answer;
    }
}