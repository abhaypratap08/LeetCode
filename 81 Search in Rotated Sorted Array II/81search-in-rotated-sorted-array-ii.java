class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target;

        int left = 0;
        int right = nums.length - 1;

        int pvtNum = pivot(nums, left, right);
        if (pvtNum == -1) {
            for (int num : nums) {
                if (num == target) return true;
            }
            return false;
        }

        return searchTar(0, pvtNum - 1, target, nums) ||
               searchTar(pvtNum, nums.length - 1, target, nums);
    }

    private int pivot(int[] nums, int left, int right) {

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (middle > 0 && nums[middle] < nums[middle - 1]) {
                return middle;
            }

            if (nums[left] == nums[middle] && nums[middle] == nums[right]) {
                left++;
                right--;
            }
            else if (nums[middle] >= nums[left]) {
                left = middle + 1;
            } 
            else {
                right = middle - 1;
            }
        }
        return -1;
    }

    private boolean searchTar(int left, int right, int target, int nums[]) {

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return true;
            }

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}