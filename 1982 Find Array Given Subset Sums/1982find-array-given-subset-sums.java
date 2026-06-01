class Solution {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int size = sums.length;
        int[] answer = new int[n];
        int[] lowerHalf = new int[size / 2];
        int[] upperHalf = new int[size / 2];

        for (int i = 0; i < n; i++) {
            int diffValue = sums[1] - sums[0];
            int zeroDetected = 0;
            int leftIndex = -1;
            int rightIndex = -1;
            int indexPointer = 0;

            for (int j = 0; j < size; j++) {
                if (indexPointer <= rightIndex && upperHalf[indexPointer] == sums[j]) {
                    indexPointer++;
                } else {
                    if (sums[j] == 0) zeroDetected = 1;
                    lowerHalf[++leftIndex] = sums[j];
                    upperHalf[++rightIndex] = sums[j] + diffValue;
                }
            }

            if (zeroDetected == 1) {
                answer[i] = diffValue;
                sums = lowerHalf;
            } else {
                answer[i] = -diffValue;
                sums = upperHalf;
            }

            size /= 2;
        }

        return answer;
    }
}
