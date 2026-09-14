class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
    long maxArea = 0;
    int n = bottomLeft.length;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {

            long leftX  = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
            long rightX = Math.min(topRight[i][0],  topRight[j][0]);

            long lowerY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
            long upperY = Math.min(topRight[i][1],  topRight[j][1]);

            if (leftX < rightX && lowerY < upperY) {
                long side = Math.min(rightX - leftX, upperY - lowerY);
                maxArea = Math.max(maxArea, side * side);
            }
        }
    }
    return maxArea;
}
}