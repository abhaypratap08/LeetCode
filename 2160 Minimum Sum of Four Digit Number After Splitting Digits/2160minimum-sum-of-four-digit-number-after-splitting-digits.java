class Solution {
    public int minimumSum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);

        int left = 0, right = 0;

        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0)
                right = right * 10 + (digits[i] - '0');
            else
                left = left * 10 + (digits[i] - '0');
        }

        return left + right;
    }
}
