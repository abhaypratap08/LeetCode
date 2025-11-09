class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(List<Integer> pos : map.values()){
            if(pos.size()<3) continue;
            for(int i=0; i+2<pos.size();i++){
                int dist = 2* (pos.get(i+2)-pos.get(i));
                if(dist<ans) ans = dist;
            }
        }
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}