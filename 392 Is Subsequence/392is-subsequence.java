class Solution {
    public boolean isSubsequence(String s, String t) {
        return fun(s, t, 0, 0); 
    }
    public boolean fun(String s, String t, int i, int j){
        if(i == s.length()) return true;
        if(j == t.length()) return false;
        if(s.charAt(i) == t.charAt(j)) return fun(s,t,i+1, j+1);
        return fun(s, t, i, j+1);
    }
}