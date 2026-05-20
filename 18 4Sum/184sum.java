import java.util.*;

class Solution {

    int len = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {

        len = nums.length;

        Arrays.sort(nums);

        return kSum(nums, (long) target, 4, 0);
    }

    private ArrayList<List<Integer>> kSum(int[] nums,
                                          long target,
                                          int k,
                                          int index) {

        ArrayList<List<Integer>> res = new ArrayList<>();

        // base boundary check
        if (index >= len) {
            return res;
        }

        // pruning optimization
        if ((long) nums[index] * k > target ||
            (long) nums[len - 1] * k < target) {
            return res;
        }

        // 2Sum base case
        if (k == 2) {

            int i = index;
            int j = len - 1;

            while (i < j) {

                long sum = (long) nums[i] + nums[j];

                if (sum == target) {

                    List<Integer> temp = new ArrayList<>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);

                    res.add(temp);

                    // skip duplicates
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }

                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }

                    i++;
                    j--;

                } else if (sum < target) {

                    i++;

                } else {

                    j--;
                }
            }

        } else {

            for (int i = index; i < len - k + 1; i++) {

                // skip duplicates
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }

                ArrayList<List<Integer>> temp =
                        kSum(nums,
                             target - nums[i],
                             k - 1,
                             i + 1);

                for (List<Integer> t : temp) {

                    t.add(0, nums[i]);

                    res.add(t);
                }
            }
        }

        return res;
    }
}