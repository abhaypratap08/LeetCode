class Solution {
    public int[] findOrder(int n, int[][] p) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            int v1=p[i][1];
            int v2=p[i][0];
            map.get(v1).add(v2);
        }
        System.out.print(map);
        Stack<Integer> st=new Stack<>();
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(dfs(st,map,vis,i)){
                    return new int[]{};
                }
            }
        }
        int[] arr=new int[st.size()];
        int i=0;
        System.out.print(st);
        while(!st.isEmpty()){
            arr[i]=st.pop();
            i++; 
       }
       if(arr.length!=n){
        return new int[]{};
       }
       return arr;
        
    }
    public static boolean dfs(Stack<Integer> st, HashMap<Integer,ArrayList<Integer>> map,int[] vis,int i){
        vis[i]=1;
        for(int nbrs:map.get(i)){
            if(vis[nbrs]==0){
                dfs(st,map,vis,nbrs);
            }
            else if(vis[nbrs]==1){
                return true;
            }
        }
        vis[i]=2;
        st.push(i);
        return false;
    }
    
}