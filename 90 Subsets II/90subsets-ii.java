class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int size = 1; size <= nums.length; size ++)
        {
            backtrack(0, size, nums, new ArrayList<>(), res);
        }
        res.add(new ArrayList<>());
        return res;
    }
    static void backtrack(int index, int size, int[] nums, List<Integer> current, List<List<Integer>> res)
    {
        if(current.size() == size)
        {
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < nums.length; i ++)
        {
            if(i > index && nums[i] == nums[i - 1])
            {
                continue;
            }
            current.add(nums[i]);
            backtrack(i + 1, size, nums, current, res);
            current.remove(current.size() - 1);
        }
    }
}