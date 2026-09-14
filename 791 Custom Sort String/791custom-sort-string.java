class Solution { 
    public String customSortString(String order, String s) {
        int[] freqTable = new int[26];

        for (char ch : s.toCharArray()) {
            freqTable[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for (char o : order.toCharArray()) {
            while (freqTable[o - 'a'] > 0) {
                ans.append(o);
                freqTable[o - 'a']--;
            }
        }

        for (char ch : s.toCharArray()) {
            while (freqTable[ch - 'a'] > 0) {
                ans.append(ch);
                freqTable[ch - 'a']--;
            }
        }

        return ans.toString();
    }
}