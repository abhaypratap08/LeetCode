class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int longest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
        }
        if (st.isEmpty()) {
            return n;
        }

        int a = n;
        while (!st.isEmpty()) {
            int b = st.pop();
            longest = Math.max(longest, a - b - 1);
            a = b;
        }

        longest = Math.max(longest, a);

        return longest;
    }
}
