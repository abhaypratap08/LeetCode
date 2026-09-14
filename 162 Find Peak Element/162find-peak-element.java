class Solution {
    public int findPeakElement(int[] nums) {
        int st = 0;
        int end = nums.length - 1;
        while (st < end) {
            int mid = (st + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;          
            } else {
                st = mid + 1;       
            }
        }
        return st;   
    }
}
