class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert string to char array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Add to map
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }

        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }
}