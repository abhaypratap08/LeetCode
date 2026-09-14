class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int i, n = nums.length;
        int min[] = new int[n];
        min[n-1] = nums[n-1];
        for(i=n-2;i>=0;i--)
        {
            min[i] = Math.min(min[i+1],nums[i]);
        }
        int max=0;
        for(i=0;i<n;i++)
        {
            max = Math.max(max,nums[i]);
            if(max-min[i]<=k)
                return i;
        }
        return -1;
    }
}