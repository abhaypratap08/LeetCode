class Solution {
    private int LowerBound(int[] arr, int lo, int hi, int target) {
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target) {
                    ans = mid;
                }
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private int LastOccurrence(int[] arr, int lo, int hi, int target) {
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                if (arr[mid] == target) ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int fst =LowerBound(arr, 0, n - 1, target);
        int lst = LastOccurrence(arr, 0, n - 1, target);
        return new int[]{fst, lst};
    }
}