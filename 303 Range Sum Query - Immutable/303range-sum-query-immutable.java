class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i]= arr[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right){
        while(left==0){
            return arr[right+1];
        }
        return (arr[right+1] - arr[left]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */