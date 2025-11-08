class Solution {
    String[] dp;
    
    public String func(int[]cost,int t){
        if(t==0){
            return "";
        }
        if(dp[t]!=null){
            return dp[t];
        }
        String max="0";
        for(int i=0;i<9;i++){
            if(t>=cost[i]){
                String curr=func(cost,t-cost[i]);
                if(curr.equals("0")){
                    continue;
                }
                curr=(i+1)+curr;
                if((curr.length()>=max.length()&&max.compareTo(curr)<0)){
                    max=curr;
                }
            }
        }
        return dp[t]=max;
    } 
    
    public String largestNumber(int[] cost, int target) {
        dp=new String[target+1];
        return func(cost,target);
    }
}