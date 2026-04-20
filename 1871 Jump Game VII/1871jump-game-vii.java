class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s == null || s.length() == 0) return false;
        int n = s.length();
        if(s.charAt(0) == '1' || s.charAt(n - 1) == '1') return false;
        
        
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        int start = 0;  //the start index of sliding windows to check
        int end = 0;  //the end index of sliding windows to check
        for(int i = 0; i < n; i++){
            if(!dp[i]){    // quick skip, if current position can't reach
                continue;
            }
            
            start = Math.max(end + 1, i + minJump);  // skip the position already checked
            end = Math.min(n - 1, i + maxJump);  // avoid overflow
 
            for(int j = start; j <= end; j++){
                if(s.charAt(j) == '0'){
                    dp[j] = true; 
                }                
            }
            if(dp[n - 1]) return true;
        }
        return dp[n-1];
    }
}