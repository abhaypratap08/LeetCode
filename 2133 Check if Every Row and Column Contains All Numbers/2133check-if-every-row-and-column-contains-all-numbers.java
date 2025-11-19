class Solution {
    public boolean checkValid(int[][] mat) {
        int n=mat.length;
        for(int i=0;i<n;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int j=0;j<n;j++){
                if(mat[i][j]>0 && mat[i][j]<=n){
                    set.add(mat[i][j]);
                }
            }
            if(set.size()!=n) return false;
        }
        for(int i=0;i<n;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int j=0;j<n;j++){
                if(mat[i][j]>0 && mat[i][j]<=n){
                    set.add(mat[j][i]);
                }
            }
            if(set.size()!=n) return false;
        }
        return true;
    }
}