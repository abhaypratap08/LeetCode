class Solution {
    public long countCommas(long n) {
        long counter = 1000;
        long result = 0;
        while(n >= counter){
            result += (n - counter + 1);
            counter *= 1000;
        }
        return result;
    }
}