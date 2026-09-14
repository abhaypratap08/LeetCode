class Solution {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++){
            int k = arr[i], j=i-1 ;
            while(j>=0 && arr[j]>k){
                arr[j+1] = arr[j];
                j--; 
            }
            arr[j+1] = k;
        }
        return arr;
    }
}