class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, pivot = 0, rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        while ((pivot < nums.length - 1) && rightSum != leftSum) {
            pivot++;
            rightSum -= nums[pivot];
            leftSum += nums[pivot - 1];
        }
        return (leftSum == rightSum) ? pivot : -1;
    }
}