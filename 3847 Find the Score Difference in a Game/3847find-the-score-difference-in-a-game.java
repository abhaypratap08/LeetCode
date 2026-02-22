class Solution {
    public int scoreDifference(int[] nums) {
        int first = 0, second = 0;
        boolean k = true;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]%2==1){
                k = !k;
            }
            if(i%6==5){
                k =!k;
            }
            if(k){
                first += nums[i];
            }else{
                second += nums[i];
            }
        }
        return first-second;
    }
}