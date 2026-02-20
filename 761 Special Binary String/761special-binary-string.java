class Solution {
    public String makeLargestSpecial(String s) {
        List<String> strings = new ArrayList<>();  
        int st = 0;                                 
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) == '1' ? 1 : -1;

            if (sum == 0) {
                String in = s.substring(st + 1, i);   
                strings.add("1" + makeLargestSpecial(in) + "0");  
                st = i + 1;
            }
        }

        Collections.sort(strings, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();

        for (String str : strings) {
            result.append(str);
        }

        return result.toString();
    }
}