class Solution {
    //Visited boolean array  is not required.. 
//The loop is not possible because... i can only jump to less value.. from lesser value jumping back to higher value is not posible.

private int maxJumpsUtil(int [] arr, int d , int st , int [] cache){

    if(st<0 || st >= arr.length){ //If i am out of array boundaries return 
        return 0;
    }
    else{
        int res = 0;
        if(cache[st]!=-1)
            res = cache[st];
        else{
            int right=0;
            for(int i = st+1 ; i<=st+d && i<arr.length ; i++){
                if(arr[st]>arr[i])//then try visiting it.
                    right = Math.max(right,maxJumpsUtil(arr,d,i,cache));
                else //even if one of the index value is greater than arr[st] break;
                    break;
            }

            int left=0;
            for(int i = st-1 ; i>=st-d && i>=0 ; i--){
               if(arr[st]>arr[i])
                    left = Math.max(left,maxJumpsUtil(arr,d,i,cache));
                else
                    break;
            }

            res = 1+ Math.max(right , left); // Plus One is for the st cell.
            cache[st] = res;
            
        }
        
        return res;
    }
    
    
}

public int maxJumps(int[] arr, int d) {
    
    int max = Integer.MIN_VALUE;
    
    // boolean [] visited = new boolean[arr.length];
        int [] cache = new int[arr.length];
       
    for(int i=0;i<arr.length;i++){
        Arrays.fill(cache,-1);
        
        int curMax = maxJumpsUtil(arr,d,i,cache);
        
        max = Math.max(max , curMax);

    }
    
    return max;
}
}