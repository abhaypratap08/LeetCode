class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int insertIndex = 2;
        for (int currentIndex = 2;
             currentIndex < nums.length;
             currentIndex++) {
            if (nums[currentIndex] != nums[insertIndex - 2])
                nums[insertIndex++] = nums[currentIndex];
        }
        return insertIndex;
    }
}