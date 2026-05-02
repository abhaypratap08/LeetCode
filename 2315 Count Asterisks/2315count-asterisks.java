class Solution {
    public int countAsterisks(String s) {
        int n=s.length();
        int count=0;
        int count_=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='|') {
                count_++;
            }
            else if(count_%2==0 &&s.charAt(i)=='*'){
                count++;
            }
        
        }
         
         return count;
    }
}