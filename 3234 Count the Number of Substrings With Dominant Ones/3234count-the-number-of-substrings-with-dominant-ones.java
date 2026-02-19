import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        List<Integer> zeroIdx = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroIdx.add(i);
            }
        }
        
        int totalZeros = zeroIdx.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int firstZeroPtr = Collections.binarySearch(zeroIdx, i);
            if (firstZeroPtr < 0) {
                firstZeroPtr = -(firstZeroPtr + 1);
            }

            int firstZeroPos = (firstZeroPtr < totalZeros) ? zeroIdx.get(firstZeroPtr) : n;
            ans += (firstZeroPos - i);

            for (int z = firstZeroPtr; z < totalZeros; z++) {
                int count0 = z - firstZeroPtr + 1;
                if (count0 * count0 > n) break;

                int currentZeroIdx = zeroIdx.get(z);
                int nextZeroIdx = (z + 1 < totalZeros) ? zeroIdx.get(z + 1) : n;

                int onesRequired = count0 * count0;
                int currentOnes = (currentZeroIdx - i + 1) - count0;

                int neededMore = Math.max(0, onesRequired - currentOnes);
                int availableOnes = nextZeroIdx - currentZeroIdx - 1;

                if (availableOnes >= neededMore) {
                    ans += (availableOnes - neededMore + 1);
                }
            }
        }

        return ans;
    }
}