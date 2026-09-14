class Solution {

    private static class SegmentTree {

        private final int n;
        private final int[] pre;
        private final int[] suf;
        private final int[] best;
        private final char[] cs;

        public SegmentTree(String s) {

            n = s.length();

            pre = new int[n << 2];
            suf = new int[n << 2];
            best = new int[n << 2];

            cs = s.toCharArray();

            build(1, 0, n - 1);
        }

        private void build(int node, int l, int r) {

            // Leaf node
            if (l == r) {
                pre[node] = 1;
                suf[node] = 1;
                best[node] = 1;
                return;
            }

            int mid = (l + r) >>> 1;

            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);

            pushUp(node, l, r);
        }

        private void pushUp(int node, int l, int r) {

            int left = node << 1;
            int right = node << 1 | 1;

            int mid = (l + r) >>> 1;

            int lenL = mid - l + 1;
            int lenR = r - mid;

            // Prefix initially comes from the left child
            pre[node] = pre[left];

            // Suffix initially comes from the right child
            suf[node] = suf[right];

            // Best answer is initially the best of either child
            best[node] = Math.max(best[left], best[right]);

            // Can the repeating sequence cross the boundary?
            if (cs[mid] == cs[mid + 1]) {

                // Entire left segment has the same character
                if (pre[left] == lenL) {
                    pre[node] = lenL + pre[right];
                }

                // Entire right segment has the same character
                if (suf[right] == lenR) {
                    suf[node] = lenR + suf[left];
                }

                // Combine suffix of left + prefix of right
                best[node] = Math.max(
                    best[node],
                    suf[left] + pre[right]
                );
            }
        }

        public void update(int i) {
            update(1, 0, n - 1, i);
        }

        private void update(int node, int l, int r, int i) {

            // Reached the leaf
            if (l == r) {
                return;
            }

            int mid = (l + r) >>> 1;

            if (i <= mid) {
                update(node << 1, l, mid, i);
            } else {
                update(node << 1 | 1, mid + 1, r, i);
            }

            // Recalculate this node
            pushUp(node, l, r);
        }

        public void updateChar(char c, int i) {
            cs[i] = c;
        }
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int k = queryIndices.length;

        SegmentTree tree = new SegmentTree(s);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];

            // Change the character
            tree.updateChar(
                queryCharacters.charAt(i),
                index
            );

            // Update the Segment Tree
            tree.update(index);

            // Root stores the answer for the entire string
            ans[i] = tree.best[1];
        }

        return ans;
    }
}