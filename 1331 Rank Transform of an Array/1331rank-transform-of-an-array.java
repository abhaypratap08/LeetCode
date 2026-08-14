class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
		Arrays.sort(temp);

		HashMap<Integer, Integer> rankMap = new HashMap<>();
		int rank = 1;
		for (int n : temp) {
			if (!rankMap.containsKey(n)) {
				rankMap.put(n, rank);
				rank++;
			}

		}
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = rankMap.get(arr[i]);
		}
		return result;
    }
}