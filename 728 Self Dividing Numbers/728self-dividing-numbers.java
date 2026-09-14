import java.util.*;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isDivivsible(i)) {
                result.add(i);
            }
        }

        return result;
    }

    static boolean isDivivsible(int num) {
        int divisor = num;

        while (divisor > 0) {
            int digit = divisor % 10;

            if (digit == 0) return false;
            if (num % digit != 0) return false;

            divisor = divisor / 10;
        }

        return true;
    }
}