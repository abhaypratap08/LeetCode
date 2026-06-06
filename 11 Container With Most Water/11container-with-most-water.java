class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        
        while (left < right) {
            // Calculate height limit and width of the container
            int h = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, h * (right - left));
            
            // Move the pointer pointing to the shorter wall inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}