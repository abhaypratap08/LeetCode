class Solution {
    public int voting(List<Integer> nums, int n){
        int freq = 1, dominant = nums.get(0);

        for(int i = 1; i < n; i++){
            if(nums.get(i) != dominant){
                freq--;
            }else{
                freq++;
            }

            if(freq == 0){
                dominant = nums.get(i);
                freq = 1;
            }
        }

        return dominant;
    }

    public int minimumIndex(List<Integer> nums) {
        int n = nums.size(), dominant, f1 = 0, f2 = 0;

        dominant = voting(nums, n);

        for(int num : nums){
            if(num == dominant){
                f1++;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums.get(i) == dominant){
                f2++;
                f1--;
            }
            if(f2 > (i + 1) / 2 && f1 > (n - i - 1) / 2){
                return i;
            }
        }

        return -1;
    }
}