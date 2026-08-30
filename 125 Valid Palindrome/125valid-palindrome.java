class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder f = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                f.append(Character.toLowerCase(c));
            }
        }
        StringBuilder r = new StringBuilder(f).reverse();
        return f.toString().equals(r.toString());
    }
}