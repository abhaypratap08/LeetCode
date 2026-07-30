class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if( n == 0) return 0;

        int lastnumber = Integer.MIN_VALUE;
        int longest =1;
        int cnt = 0;
        Arrays.sort(nums);

        for(int  i =0 ; i<n;i++){
            if(nums[i]-1 == lastnumber){
                cnt +=1;
                lastnumber = nums[i];
            }
            else if(nums[i] != lastnumber){
                cnt = 1;
                lastnumber = nums[i];
            }
            longest = Math.max(longest,cnt);
        }

        return longest;   
    }
}