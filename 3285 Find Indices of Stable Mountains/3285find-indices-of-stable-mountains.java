class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<height.length-1;i++){
            if(height[i]>threshold) arr.add(i+1);
        }
        return arr;
    }
}