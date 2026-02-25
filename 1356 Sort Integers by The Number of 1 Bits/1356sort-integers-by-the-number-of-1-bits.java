import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> {
            int bitsA = countBitsSlow(a);
            int bitsB = countBitsSlow(b);

            if (bitsA == bitsB) return a - b;
            return bitsA - bitsB;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }

    private int countBitsSlow(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) { 
            if ((num & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}