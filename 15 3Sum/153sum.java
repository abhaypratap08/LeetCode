class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int lo = i + 1, hi = nums.length - 1;
            while(lo<hi){
                int total = nums[i] + nums[lo] + nums[hi];
                if(total>0){
                    hi--;
                }else if(total < 0){
                    lo++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    while (nums[lo]==nums[lo-1] && lo<hi) {
                        lo++;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}