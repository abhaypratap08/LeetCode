class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){if(n%k==0){set.add(n/k);}}
        int i = 1;
        while(set.contains(i)){i++;} return i*k;
    }
}