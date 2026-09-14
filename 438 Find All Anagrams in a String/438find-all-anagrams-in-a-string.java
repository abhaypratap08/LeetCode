class Solution {
    public List<Integer> findAnagrams(String s, String str) {
        List<Integer> anagramList = new ArrayList<>();
        int x = str.length();
        int y = s.length();
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        for (int i = 0; i < s.length(); i++) {
            String s1 = "";
            if (x <= y) {
                s1 = s.substring(i, x);
                char[] ch1 = s1.toCharArray();
                Arrays.sort(ch1);
                if (Arrays.equals(ch, ch1)) {
                    anagramList.add(i);
                }
                x++;
            }
        }
        return anagramList;
    }
}