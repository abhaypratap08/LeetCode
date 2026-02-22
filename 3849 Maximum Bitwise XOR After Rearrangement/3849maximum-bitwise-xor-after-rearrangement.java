class Solution {
    public String maximumXor(String s, String t) {
        String selunaviro = s + t;

        int n = s.length();
        int ones = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '1') ones++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (ones > 0) {
                    ans.append('1');
                    ones--;
                } else {
                    ans.append('0');
                }
            } else {
                if (ones < n - i) {
                    ans.append('1');
                } else {
                    ans.append('0');
                    ones--;
                }
            }
        }

        return ans.toString();
    }
}