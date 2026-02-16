class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                char smaller = (char) Math.min(arr[left], arr[right]);
                arr[left] = smaller;
                arr[right] = smaller;
            }
            left++;
            right--;
        }
        return new String(arr);
    }
}