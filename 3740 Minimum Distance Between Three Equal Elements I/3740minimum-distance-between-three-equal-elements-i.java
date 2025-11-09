class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int Mindist = Integer.MAX_VALUE;
        for(List<Integer> indices : map.values()){
            if(indices.size()<3) continue;
            for(int i=0; i+2<indices.size();i++){
                int a = indices.get(i);
                int b = indices.get(i+1);
                int c = indices.get(i+2);
                int dist = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
                Mindist = Math.min(Mindist, dist);
            }
        }
        return Mindist == Integer.MAX_VALUE ? -1: Mindist;
    }
}