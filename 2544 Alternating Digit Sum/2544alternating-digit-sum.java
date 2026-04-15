class Solution {
    public int alternateDigitSum(int n) {

        int sum = 0;
        boolean flag = true;
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        while (rev != 0) {
            int digit = rev % 10;
            if (flag) {
                sum = sum + digit;
                flag = false;
            } else {
                sum -= digit;
                flag = true;
            }
            rev /= 10;

        }
        return sum;
    }
}