class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i]%2==0 && nums[i]<=threshold) {
                int e = i+1;
                while(e<n && nums[e]<=threshold && nums[e]%2!=nums[e-1]%2){
                    e++;
                }
                ans = Math.max(ans, e-i);
            }
        }
        return ans;
    }
}