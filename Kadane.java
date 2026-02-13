public class Solution {
    public long solve(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        long maxEndingHere = A[0];
        long maxSoFar = A[0];
        
        for (int i = 1; i < A.length; i++) {
            // Either extend the previous subarray or start new from current element
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            
            // Update global maximum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}
