class Solution {
    long MOD = 1000000007;
    public int minNonZeroProduct(int p) {
      long max = (1L<<p)-1;
      long second = max-1;
      long power = (1L<<(p-1))-1; 
      long result = (fastexp(second,power) * (max%MOD))%MOD;
      return (int) result; 
    }
    public long fastexp(long base, long exp){
        base = base%MOD;
        if(exp==0) return 1;

        long half = fastexp(base,exp/2);

        if(exp%2==0){
            return (half*half)%MOD;
        }
        else{
            return (half*half % MOD * base) % MOD;
        }
    }
}