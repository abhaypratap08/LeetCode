class Solution {
    public void sortColors(int[] nums) {
        SSort(nums);
    }
    public static int[] SSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int lastIndex = arr.length-i-1;
            int maxIndex = maxx(arr, 0, lastIndex);
            swapp(arr, maxIndex, lastIndex);
        }
        return arr;
    }
    static int maxx(int[] arr, int first, int last){
        int max = first;
        for (int i = first; i <= last; i++) {
            if(arr[i]>arr[max]) max = i;
        }
        return max;
    }
    public static int[] swapp(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
        return arr;
    }
}