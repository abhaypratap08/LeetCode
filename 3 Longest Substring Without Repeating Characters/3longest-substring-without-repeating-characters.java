import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int max = 0, start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (lastSeen.containsKey(c) && lastSeen.get(c) >= start) {
                start = lastSeen.get(c) + 1;
            }

            lastSeen.put(c, end);
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
