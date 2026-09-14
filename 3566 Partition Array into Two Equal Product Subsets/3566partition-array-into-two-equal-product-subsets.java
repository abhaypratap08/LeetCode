class Solution {
    boolean solve(int[] nums,int i,long p1,long p2,long target){
        if(i == nums.length) return p1 == target && p2 == target;
        boolean a = solve(nums,i+1,p1*nums[i],p2,target);
        boolean b = solve(nums,i+1,p1,p2*nums[i],target);
        return a | b;
    }
    public boolean checkEqualPartitions(int[] nums, long target) {
        return solve(nums,0,1,1,target);
    }
}