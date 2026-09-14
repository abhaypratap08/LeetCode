class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length ,m =arr2.length ,max = 0;
        for(int i : arr1){
            max = Math.max(max,i);
        }

        int[] countArr = new int[max+1];

        for(int i : arr1){
            countArr[i]++;
        }

        int idx = 0;
        int[] result = new int[n];

        for(int i : arr2){
            while(countArr[i]>0){
                result[idx++] = i;
                countArr[i]--;
            }
        }
        for(int i = 0; i< countArr.length ; i++){
            while(countArr[i]>0){
                result[idx++] = i;
                countArr[i]--;
            }
        }
        return result;
    }
}