public class Solution {
    public int pow(int A, int B, int C) {
        // Base case for A^0
        if (B == 0) return 1 % C;
        if (A == 0) return 0;

        long res = calculatePow(A, B, C);
        
        // Ensure the result is non-negative
        if (res < 0) {
            res = (res + C) % C;
        }
        
        return (int) res;
    }

    private long calculatePow(long a, long b, long c) {
        if (b == 0) return 1;
        
        // Recursive step: compute a^(b/2)
        long halfPow = calculatePow(a, b / 2, c);
        long halfPowSquared = (halfPow * halfPow) % c;

        if (b % 2 == 0) {
            return halfPowSquared;
        } else {
            // If b is odd, multiply by an extra 'a'
            return (a % c * halfPowSquared) % c;
        }
    }
}
