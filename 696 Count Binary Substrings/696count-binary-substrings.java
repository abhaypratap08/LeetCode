class Solution {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int prev = 0;
        int curr = 1;
        int count = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                curr++;
            } else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        return count + Math.min(prev, curr);
    }
}