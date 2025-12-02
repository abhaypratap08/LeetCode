class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> vowelPosition = new HashMap<>();
        vowelPosition.put('a', 0);
        vowelPosition.put('e', 1);
        vowelPosition.put('i', 2);
        vowelPosition.put('o', 3);
        vowelPosition.put('u', 4);

        HashMap<Integer, Integer> lastOccurred = new HashMap<>();
        lastOccurred.put(0, -1); 
        
        int cur = 0; 
        int maxLen = 0; 
        
        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);

            if (isVowel(currentChar)) {
                cur ^= (1 << vowelPosition.get(currentChar));
            }
            if (lastOccurred.containsKey(cur)) {
                maxLen = Math.max(maxLen, r - lastOccurred.get(cur));
            } else {
                lastOccurred.put(cur, r);
            }
        }

        return maxLen;
    }
}