class Solution {
    public char kthCharacter(int k) {
        StringBuilder res = new StringBuilder();
        res.append("a");   
        while(res.length()<k){
            StringBuilder sb = new StringBuilder();
            String temp = res.toString();
            for(char j : temp.toCharArray()){
                sb.append((char) (j+1));
            }
            res.append(sb);
        }
        return res.charAt(k-1);
    }
}