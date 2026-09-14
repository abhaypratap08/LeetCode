class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        for (int i = 0; i < f.length; i++) {
            if(i + 1 != f.length && f[i+1] == 1) continue;
            if (f[i] != 1) {
                n--;
                i++;
            } else i++;
        }
        return n <= 0;
    }
}