class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String s = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;

        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            } else {
                ans.append(j - i);
                ans.append(s.charAt(i));
                i = j;         
            }
        }

        ans.append(j - i);
        ans.append(s.charAt(i));

        return ans.toString();
    }
}
