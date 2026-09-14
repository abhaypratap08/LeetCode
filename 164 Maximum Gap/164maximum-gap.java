class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length <2)return 0;
        List<Integer> diff = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++)diff.add(nums[i+1] - nums[i]);
        return Collections.max(diff);
    }
}