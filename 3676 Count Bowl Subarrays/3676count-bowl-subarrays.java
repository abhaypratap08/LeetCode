class Solution {
    public long bowlSubarrays(int[] nums) {
        int res=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int curr = st.pop();
                if(i-curr+1>=3) {
                    res++;
                }
            }
            if(!st.isEmpty() && i - st.peek() +1>=3) {
                res++;
            }
            st.push(i);
        }
        return res;
    }
}