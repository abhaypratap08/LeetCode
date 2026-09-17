class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int max = (int)1e9;
        int len[] = new int[arr.length];
        Arrays.fill(len,max);
        int sum = 0;
        for(int i = 0,j = 0;i <= j && j < arr.length;j++){
            sum += arr[j];
            for(;i <= j && sum > target;){
                sum -= arr[i];
                i++;
            }
            if(sum == target){
                len[i] = j - i + 1;
            }
        }
        int min[] = new int[arr.length];
        Arrays.fill(min,max);
        min[arr.length - 1] = len[arr.length - 1];
        for(int i = arr.length - 2;i >= 0;i--){
            min[i] = Math.min(len[i],min[i + 1]);
        }
        int ans = max;
        for(int i = 0;i < arr.length;i++){
            if(i + len[i] < arr.length) ans = Math.min(ans,len[i] + min[i + len[i]]);
        }
        return ans >= max ? -1 : ans;
    }
}