class Solution {
    public boolean isMatch(String s, String p) {
        return isMatching(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
    }
    
    private boolean isMatching(String s, String p, int i, int j, Boolean[][] dp) {
        if (i >= s.length() && j >= p.length()) return true;
        
        if (j >= p.length()) return false;
        
        if (dp[i][j] != null) return dp[i][j];

        boolean matchCondition = i < s.length() && 
                                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            dp[i][j] = isMatching(s, p, i, j + 2, dp) ||   // skip `*` pattern
                       (matchCondition && isMatching(s, p, i + 1, j, dp)); // use `*`
        } else {
            if (matchCondition) {
                dp[i][j] = isMatching(s, p, i + 1, j + 1, dp);
            } else {
                dp[i][j] = false;
            }
        }
        return dp[i][j];
    }
}