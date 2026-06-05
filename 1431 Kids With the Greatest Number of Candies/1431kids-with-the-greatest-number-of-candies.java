class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        boolean[] arr = new boolean[candies.length];
        int max = 0;
        // Find maximum candies
        for(int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        // Check each kid
        for(int i = 0; i < candies.length; i++) {

            if((candies[i] + extraCandies) >= max) {
                arr[i] = true;
            }
            else {
                arr[i] = false;
            }
        }
        for(boolean n : arr) {
            ans.add(n);
        }

        return ans;
    }
}