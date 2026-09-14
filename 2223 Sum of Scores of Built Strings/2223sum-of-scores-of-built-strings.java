class Solution {
    public static long sumScores(String s) {
		int[] ans = patternMatching(s.toCharArray());
		long sum = s.length();
		for (int i : ans) {
			sum += i;
		}
		return sum;
	}

	public static int[] patternMatching(char[] ch) {
		int[] arr = new int[ch.length];
		int low = 0;
		int high = 0;
		for (int i = 1; i < ch.length; i++) {
			if (i > high) {
				low = i;
				high = i;
				while (high < ch.length && ch[high] == ch[high - low]) {
					high++;
				}
				arr[i] = high - low;
				high--;
			} else {
				int k = i - low;
				if (arr[k] < high - i + 1) {
					arr[i] = arr[k];
				} else {
					low = i;
					while (high < ch.length && ch[high] == ch[high - low]) {
						high++;
					}
					arr[i] = high - low;
					high--;
				}
			}
		}
		return arr;
	}
}