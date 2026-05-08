class Solution {
    public int minSwapsCouples(int[] nums) {
        int n = nums.length, i = 0, j = 0, cnt = 0; 
        while(i<n){
            int p1 = nums[i], p2 = (p1%2==0) ? p1+1 : p1-1;
            j = i+1;
            if(nums[j]!=p2){
                for(int k=j; k<n; k++){
                    if(nums[k]==p2){
                        swap(nums, j, k); cnt++;
                    }
                }
            }
            i += 2;
        }
        return cnt;
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
}
