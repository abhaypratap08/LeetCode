class Solution {
    public int minLength(int[] nums, int k) {
        int[] fr = new int[100001];
        long dist = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            int val = nums[i];
            if(fr[val]==0){
                dist += val;
            }
            fr[val]++;
             for (; dist >= k; ) {
                ans = Math.min(ans, i - left + 1);
                int temp = nums[left];
                fr[temp]--;
                if (fr[temp] == 0) {
                    dist -= temp;
                }
                left++;
            }
            // while(dist >= k) { 
            //     ans = Math.min(ans, i-left + 1);
            //     int leftval = nums[left]; 
            //     fr[leftval]--; 
            //     if (fr[leftval] == 0) { 
            //         dist -= leftval; 
            //     }
            //     left++;
            // }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }else return ans;
    }
}