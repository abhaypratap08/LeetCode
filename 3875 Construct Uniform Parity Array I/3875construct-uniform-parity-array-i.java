class Solution {
    public boolean uniformArray(int[] nums1) {
        int e = 0, o = 0;
        for(int num : nums1){
            if(num%2 == 0) e++;
            else o++;
        }

        if(e == nums1.length) return true;
        if(o >= 1) return true;

        return false;
    }
}