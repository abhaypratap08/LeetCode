class Solution {
    public static int calculate(String s) {
            return eval(s, 0)[0];
        }

        public static int[] eval(String s, int i) {
            int num = 0;
            int sign = 1;
            int result = 0;

            while (i < s.length()) {
                char c = s.charAt(i);

                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                else if (c == '+') {
                    result += sign * num;
                    num = 0;
                    sign = 1;
                }
                else if (c == '-') {
                    result += sign * num;
                    num = 0;
                    sign = -1;
                }
                else if (c == '(') {
                    int[] sub = eval(s, i + 1); 
                    result += sign * sub[0];
                    num = 0;
                    i = sub[1];
                }
                else if (c == ')') {
                    result += sign * num;
                    return new int[]{result, i};
                }

                i++;
            }

            result += sign * num;
            return new int[]{result, i};
        }
}