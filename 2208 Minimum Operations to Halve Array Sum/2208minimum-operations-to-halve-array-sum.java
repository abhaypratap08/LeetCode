class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        double sum = 0;
        for(int i : nums){
            sum += i;
            pq.add((double)i);
        }

        sum = sum/2;
        int ans = 0;

        while(sum>0){
            double temp = pq.poll();
            temp = temp/2;
            pq.add(temp);
            sum -= temp;
            ans++;
        }
        return ans;
        
    }
}