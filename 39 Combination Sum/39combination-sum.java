import java.util.*;

class Solution {

    void solve(int[] candidates, List<Integer> temp, List<List<Integer>> ans, int i, int target) {
        
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        if (i == candidates.length) {
            return;
        }

        // pick element
        if (candidates[i] <= target) {
            temp.add(candidates[i]);
            solve(candidates, temp, ans, i, target - candidates[i]); // same index
            temp.remove(temp.size() - 1);
        }

        // not pick element
        solve(candidates, temp, ans, i + 1, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, new ArrayList<>(), ans, 0, target);
        return ans;
    }
}