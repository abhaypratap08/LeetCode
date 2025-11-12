class Solution {
    public int[] separateDigits(int[] nums) {
           List<Integer> arr = new ArrayList<>();
           for(int i = nums.length-1;i>=0;i--){
                int n = nums[i];
                while(n != 0){
                     arr.add(n%10);
                     n=n/10;
                }
           }
           int[] res = new int[arr.size()];
           int in  = 0;
           for(int i = arr.size()-1;i>=0;i--){
               res[in++] = arr.get(i);
           }
           return res;
    }
}