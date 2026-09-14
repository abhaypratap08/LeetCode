class Solution {
    public int findMin(int[] nums) 
    {
        int mini = Integer.MAX_VALUE;
        int l = 0;
        int h = nums.length-1;
        while(l <= h)
        {
            int mid = (l + h) / 2;
            if(nums[l] <= nums[mid])
            {
                mini = Math.min(mini , nums[l]);
                l = mid+1;
            }
            else
            {
                mini = Math.min(mini , nums[mid]);
                h = mid-1;
            }
        }
        return mini;
    }
}