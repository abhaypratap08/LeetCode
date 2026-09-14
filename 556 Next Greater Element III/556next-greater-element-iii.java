class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int len = a.length;
        int i = len - 2;
        
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i < 0) return -1;
        
        int j = len - 1;
        while (a[j] <= a[i]) {
            j--;
        }
        
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        
        int l = i + 1;
        int r = len - 1;
        while (l < r) {
            temp = a[l];
            a[l++] = a[r];
            a[r--] = temp;
        }
        
        long val = Long.parseLong(new String(a));
        if (val > Integer.MAX_VALUE || val <= n) {
            return -1;
        } else {
            return (int) val;
        }
    }
}