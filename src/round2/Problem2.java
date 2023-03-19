package round2;

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        print();
    }

    static void print()
    {
        long[] dp = new long[57];
        Arrays.fill(dp, -1);
        for (int i = 1; i < 57; i++) {
            long ans = fibo(i, dp);
            if (i == 56) System.out.println(ans);
        }
        System.out.println(Arrays.toString(dp));
    }

    static long fibo(int i,long[] dp)
    {
        if (dp[i] != -1) return dp[i];
        if(i== 0 || i == 1 || i==2) return dp[i]= i;
        else return dp[i]= fibo(i-1,dp)+fibo(i-2, dp);
    }
}
