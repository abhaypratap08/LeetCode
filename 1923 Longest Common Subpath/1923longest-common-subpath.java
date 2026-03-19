class Solution {
    public static final int IDX = 0, RANK = 1, NEXT_RANK = 2;
    public int longestCommonSubpath(int n, int[][] paths) {
        /*
        this seems like a graph problem at first glance, but 
        it may just be a substring/subarray problem disguised as one.
        This is essentially asking for the longest common subarray from a list of arrays.

        */
        int m = paths.length, sum = m; 
        for(int[] path : paths) sum += path.length;
        int[] merged = new int[sum], owner  = new int[sum]; //owner denotes the original array/friend which "owned" owner[ptr] in the paths[][]
        int ptr = 0;
        for(int i = 0; i < m; i++) {
            for(int city : paths[i]) {
                owner[ptr] = i;
                merged[ptr++] = city;
            }
            owner[ptr] = -1;
            merged[ptr++] = n + i; //use as sentinel to seperate concats 
        }

        int[] suffix = getSuffixArray(merged);
        int[] rank = new int[sum];
        for(int i = 0; i < sum; i++) rank[suffix[i]] = i;
        int[] lcp = new int[sum];
        int h = 0;
        for(int i = 0; i < sum; i++) {
            if(rank[i] == 0) continue;
            int j = suffix[rank[i]-1];
            while(merged[i+h] == merged[j+h]) h++;
            lcp[rank[i]] = h;
            if(h > 0) h--;
        }
        int res = 0, covered = 0, left = 0;
        int[] cnt = new int[m]; //stores how much a certain friend occurs within the lcp window so we can tell when all friends are in window
        Deque<Integer> monoDeque = new ArrayDeque<>();//monondeque will store indices i into lcp[], in increasing order of lcp[i]

        for (int right = 0; right < sum; right++) {
            int id = owner[suffix[right]]; //start with the friend who owned the suffix on the right and add friend to the "covered" friends if it wasn't "covered already"
            if (id >= 0 && cnt[id]++ == 0) covered++;
            if (right > 0) {// add lcp[right] into window monoDeque
                while (!monoDeque.isEmpty() && lcp[monoDeque.peekLast()] >= lcp[right]) monoDeque.pollLast();
                monoDeque.offerLast(right);
            }
            while (covered == m) {  //if all the friends are covered (this means all have lcp in, so can take) from the left while we still cover all m paths
                if (left < right && !monoDeque.isEmpty()) res = Math.max(res, lcp[monoDeque.peekFirst()]); //the min LCP in range is the first in monoDeque (as monoDeque monotononically inc left to right)
                if (!monoDeque.isEmpty() && monoDeque.peekFirst() == left+1) monoDeque.pollFirst(); //remove left+1 from deque before closing it out of the window
                if (owner[suffix[left]] >= 0 && --cnt[owner[suffix[left]]] == 0) covered--; //if suffix being slid out of window removes a friend completely from window, decrement covered in window
                left++;
            }
        }

        return res;

    }

    private int[] getSuffixArray(int[] arr) {
        int n = arr.length;
        int[][] suf = new int[n][3]; //holds [idx, rank, next_rank]
        for(int i = 0; i < n; i++) {
            suf[i][IDX] = i;
            suf[i][RANK] = arr[i];
        }
        for(int i = 0; i < n; i++) suf[i][NEXT_RANK] = i + 1 < n ? suf[i+1][RANK] : -1;
        Arrays.sort(suf, (a, b) -> a[1] == b[1] ? a[2]-b[2] : a[1]-b[1]);
        int[] idxToPos = new int[n]; //maps the startign idx of suffix in arr to the current idx of said suffix in sorted suf array

        for(int sz = 2; sz < n; sz <<= 1) {
            int prevRankVal = suf[0][RANK];
            suf[0][RANK] = 0; //assign new rank of first to 0
            idxToPos[suf[0][IDX]] = 0;
            for(int i = 1; i < n; i++) {
                boolean isSame = suf[i][RANK] == prevRankVal && suf[i][NEXT_RANK] == suf[i-1][NEXT_RANK];
                prevRankVal = suf[i][RANK];
                suf[i][RANK] = suf[i-1][RANK] + (isSame ? 0 : 1);
                idxToPos[suf[i][IDX]] = i;
            }
            for(int i = 0; i < n; i++) suf[i][NEXT_RANK] = suf[i][IDX] + sz < n ? suf[idxToPos[suf[i][IDX] + sz]][RANK] : -1; //sets next ranks to the ranks of +sz to right neighbors
            Arrays.sort(suf, (a, b) -> a[1] == b[1] ? a[2]-b[2] : a[1]-b[1]);
        }

        int[] suffix = new int[n];
        for(int i = 0; i < n; i++) suffix[i] = suf[i][IDX];
        return suffix;
    }

}