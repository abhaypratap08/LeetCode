class Solution {
    class pair{
        long first , second;
        pair(long first , long second){
            this.first = first;
            this.second = second;
        }
    }

    public int maximumSaleItems(int[][] items, int budget) {
        long minCost = (int)1e18 , ans = 0;
        int maxF = 0;

        for(int[]item : items){
            minCost = Math.min(minCost , (long)item[1]);
            maxF = Math.max(maxF , item[0]);
        }

        int[]f = new int[maxF + 1];

        for(int[]item : items){
            f[item[0]]++;
        }

        int[]multiples = new int[maxF + 1];

        for(int i = 1; i <= maxF; i++){
            if(f[i] == 0) continue;

            for(int j = i; j <= maxF; j += i){
                multiples[i] += f[j];
            }
        }

        List<pair>validMoves = new ArrayList<>();

        for(int[]item : items){
            long limit = multiples[item[0]] - 1;

            if(limit > 0 && item[1] < 2L * minCost){
                validMoves.add(new pair(item[1] , limit));
            }
        }

        validMoves.sort((a, b) -> Long.compare(a.first, b.first));

        for(var move : validMoves){
            long take = Math.min(move.second , budget / move.first);

            ans += take * 2;
            budget -= take * move.first;
        }

        ans += budget / minCost;

        return (int)ans;
    }
}