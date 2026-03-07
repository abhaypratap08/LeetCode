class Solution {
    public int heightChecker(int[] heights) {
        int high = heights.length;
        int arr[] = new int[high];
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<high; i++){
            arr[i]=heights[i];            
        }
        Arrays.sort(arr);
        for(int i = 0; i<high; i++){
            if(arr[i]!=heights[i]){
                list.add(arr[i]);
            }
        }
        return list.size();
    }
}