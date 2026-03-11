public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        long count = 0;
        int mod = 1000000007;
        
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            // Use long to prevent overflow during multiplication
            long product = (long) A[left] * A[right];
            
            if (product < B) {
                // If A[left] * A[right] < B, then A[left] * (anything from left to right) < B
                // Number of pairs (left, i) where left <= i <= right is (right - left + 1)
                // We need (left, i) and (i, left).
                // Pairs where left < i: (left, i) and (i, left) -> 2 * (right - left)
                // Pair where left == i: (left, left) -> 1
                // Total = 2 * (right - left) + 1
                count = (count + (2L * (right - left) + 1)) % mod;
                left++;
            } else {
                right--;
            }
        }
        
        return (int) count;
    }
}
