class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] out = new int[2*n];
        for(int i =0; i<n; i++){
            out[i] = nums[i];
        }

        for(int i =0; i<n; i++){
            out[n+i] = nums[n-1-i];
        }
        return out;
    }
}