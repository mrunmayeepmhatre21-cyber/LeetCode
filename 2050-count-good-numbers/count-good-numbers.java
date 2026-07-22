class Solution {
    static final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evencount = (n+1)/2;
        long oddcount = n/2;

        long ans = (modPow(5,evencount)*modPow(4,oddcount))%MOD;
        return (int)ans;
    }
    private long modPow(int base,long exp){
        if(exp==0)return 1;
        long half = modPow(base,exp/2);
        long result = (half*half)%MOD;

        if(exp%2==1) result = (result*base)%MOD;
        return result;
    }
}