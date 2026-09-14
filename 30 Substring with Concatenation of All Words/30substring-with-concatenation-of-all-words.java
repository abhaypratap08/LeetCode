class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        int n = s.length();
        int numWords = words.length;
        if (n == 0 || numWords == 0) return result;
        
        int wordLen = words[0].length();
        int totalLen = numWords * wordLen;
        if (n < totalLen) return result;
        
        Map<String, Integer> required = new HashMap<>();
        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }
      
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int matched = 0;
            Map<String, Integer> seen = new HashMap<>();
         
            for (int j = i; j <= n - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);
            
                if (required.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
        
                    if (seen.get(word) <= required.get(word)) {
                        matched++;
                    }
                    
                    while (seen.get(word) > required.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        if (seen.get(leftWord) < required.get(leftWord)) {
                            matched--;
                        }
                        left += wordLen;
                    }
                    
                    if (matched == numWords) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    matched = 0;
                    left = j + wordLen;
                }
            }
        }
        
        return result;
    }
}