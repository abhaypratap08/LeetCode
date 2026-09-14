import java.util.*;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> posi = new ArrayList<>();
        List<Integer> negi = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int num : nums) {
            if (num > 0) {
                posi.add(num);
            } else {
                negi.add(num);
            }
        }
        
        int ind1 = 0, ind2 = 0;
        while (ind2 < nums.length / 2) {
            ans.add(posi.get(ind1));
            ind1++;
            ans.add(negi.get(ind2));
            ind2++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}


