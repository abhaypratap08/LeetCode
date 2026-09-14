class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        int strLength = str.length;
        return str[strLength - 1].length();
    }
}