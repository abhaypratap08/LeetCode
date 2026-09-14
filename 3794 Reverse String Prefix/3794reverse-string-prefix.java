class Solution {
    public String reversePrefix(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++){
            sb.append(s.charAt(i));
        }
        sb.reverse();
        for (int i = k; i < s.length(); i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
