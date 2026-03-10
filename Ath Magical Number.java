public class Solution {
    public int solve(int A, int B, int C) {
        long low = Math.min(B, C);
        long high = (long) A * Math.min(B, C);
        long ans = high;
        long mod = 1000000007;

        // Calculate Least Common Multiple: LCM(B, C) = (B * C) / GCD(B, C)
        long lcm = ((long) B * C) / gcd(B, C);

        while (low <= high) {
            long mid = low + (high - low) / 2;

            // Count how many magical numbers are <= mid
            long count = (mid / B) + (mid / C) - (mid / lcm);

            if (count >= A) {
                ans = mid;
                high = mid - 1; // Try to find a smaller number
            } else {
                low = mid + 1; // Need more magical numbers
            }
        }

        return (int) (ans % mod);
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
