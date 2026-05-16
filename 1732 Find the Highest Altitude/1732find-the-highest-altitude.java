class Solution {
    public int largestAltitude(int[] gain) {
        int currentalt = 0;
        int maxalt = 0;
        for (int j : gain) {
            currentalt = currentalt + j;
            if (currentalt > maxalt) {
                maxalt = currentalt;
            }
        }
        return maxalt;
    }
}