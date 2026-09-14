import java.util.*;

class Solution {
    public long minArraySum(int[] nums) {
        int max = 0;
        for(int x : nums){
            max = Math.max(max, x);
        }
        boolean[] seen = new boolean[max+1];
        for(int x : nums){
            seen[x] = true;
        }
        long ans = 0;
        for(int y : nums){
            int best = y;
            for(int z = 1; z*z <= y; z++){
                if(y%z == 0){
                    if(z <= max && seen[z]){
                        best = Math.min(best,z);
                    }
                    int other  = y/z;
                    if(other <= max && seen[other]){
                        best = Math.min(best, other);
                    }
                }
            }
            ans += best;
        }
        return ans;
    }
}