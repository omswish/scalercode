import java.util.Arrays;

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        long mod = 1000000007;
        
        // 1. Sort the array
        Arrays.sort(A);
        
        // 2. Precompute powers of 2 to avoid repeated calculation
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }
        
        long maxSum = 0;
        long minSum = 0;
        
        // 3. Calculate total contribution
        for (int i = 0; i < n; i++) {
            // A[i] is the max for 2^i subsequences
            maxSum = (maxSum + (long) A[i] * pow2[i]) % mod;
            
            // A[i] is the min for 2^(n-1-i) subsequences
            minSum = (minSum + (long) A[i] * pow2[n - 1 - i]) % mod;
        }
        
        // Final result: (Total Maxes - Total Mins)
        // Add mod before taking modulo to handle negative results
        return (int) ((maxSum - minSum + mod) % mod);
    }
}
