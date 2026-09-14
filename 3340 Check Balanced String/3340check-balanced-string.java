class Solution {
    public boolean isBalanced(String num) {
        int len=num.length();
        int sume=0;
        int sumo=0;
        for(int i=0;i<len;i++){
            if(i%2==0) sume+=Integer.parseInt(num.charAt(i)+"");
            else sumo+=Integer.parseInt(num.charAt(i)+"");
        }
        return sumo==sume;
    }
}