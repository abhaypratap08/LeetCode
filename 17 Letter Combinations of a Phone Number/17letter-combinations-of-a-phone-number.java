class Solution {
    private static final String[] mapping={
		"",
		"",
		"abc",
		"def",
		"ghi",
		"jkl",
		"mno",
		"pqrs",
		"tuv",
		"wxyz"
	};
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.isEmpty()) {
			return new ArrayList<>();
		}
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    private void backtrack(String digits, int index, StringBuilder current, List<String> result){
		if (index==digits.length()) {
			result.add(current.toString());
            return;
		}
		int digit=digits.charAt(index)-'0';
		String letters=mapping[digit];
		for(int i=0;i<letters.length();i++){
			char ch=letters.charAt(i);
            current.append(ch);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
		}
	}
}