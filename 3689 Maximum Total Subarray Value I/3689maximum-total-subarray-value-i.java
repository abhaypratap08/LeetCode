import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long maxopt = Arrays.stream(nums).max().getAsInt();
        long maxint = Arrays.stream(nums).min().getAsInt();
        return (maxopt - maxint) * k;

    }
}