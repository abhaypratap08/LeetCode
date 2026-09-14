class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0, j = 1;
        while(j<=arr.length-1){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
            j++; 
        }
        return i+1;
    }
}