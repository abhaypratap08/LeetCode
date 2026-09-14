class Solution {
    public int minimumRightShifts(List<Integer> a) {
        int n=a.size(),minmoves=0,count=0;
        for(int i=1;i<n;i++){
            if(a.get(i)<a.get(i-1)){
                 count++; 
                if(count>1) return -1;
                minmoves=n-i;
                
            }
        }
        if(a.get(n-1)>a.get(0) && count!=0) return -1;
        return minmoves;
    }
}