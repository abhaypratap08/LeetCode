// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int n = nums.length, count = 0;
//         for(int i = 0; i < n; i++) {
//             int sum = 0;
//             for(int j = i; j < n; j++) {
//                 sum += nums[j];
//                 if(sum == k) count++;
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int subarraySum(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixsum = 0;
        int count = 0 ;

        for(int x : nums){
            prefixsum += x;
            if(map.containsKey(prefixsum - k)){
                count  += map.get(prefixsum - k);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum, 0)+1);
        }
        return count;
    }
}
