class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int ori = x;
        if(x<0) return false;
        while(x > 0){
            rev = (rev * 10)+ (x % 10);
            x = x/10;
        }
        return rev == ori;
    }
}