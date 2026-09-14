class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int windowStart =0;
        int maxFreq = 0;
        for(int windowEnd=0; windowEnd<nums.size(); windowEnd++){
            int num = nums.get(windowEnd);
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);

            maxFreq = Math.max(maxFreq, freq+1);
            if(windowEnd - windowStart + 1 - maxFreq > k) {
                freqMap.put(nums.get(windowStart), freqMap.get(nums.get(windowStart))-1);
                windowStart++;
            }
        }
        return maxFreq;
    }
}