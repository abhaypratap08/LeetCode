class Solution {
    public int[] singleNumber(int[] nums) {
        int n =0; 
        for(int i=0;i<nums.length;i++){
            n ^= nums[i];
        }
        int mask = (n & (n-1))^n;  
        int xor1=0,xor2=0;
        for(int i=0;i<nums.length;i++){
            int number = nums[i] & mask;
            if(number ==0){
                xor1 = xor1 ^ nums[i];
            }
            else{
                xor2 = xor2 ^ nums[i];
            }
        }
        int arr[] = {xor1, xor2};
        return arr;

    }
}