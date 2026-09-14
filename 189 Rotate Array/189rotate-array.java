class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int st, end, temp;
        st = 0; 
        end = n - 1;
        while (st < end) {
            temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
        st = 0;
        end = k-1;
        while (st < end) {
            temp = nums[st];
            nums[st] = nums[end];
            nums[end]= temp;
            st++;
            end--;
        }
        st = k; 
        end = n - 1;
        while (st < end) {
            temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
}