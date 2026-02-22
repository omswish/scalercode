public class Solution {
    public Long solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if (n == 0) return 0L;
        
        int m = A.get(0).size();
        
        // Build 2D prefix sum (1-based indexing for simplicity)
        long[][] prefix = new long[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = prefix[i - 1][j] 
                             + prefix[i][j - 1] 
                             - prefix[i - 1][j - 1] 
                             + A.get(i - 1).get(j - 1);
            }
        }
        
        long maxSum = Long.MIN_VALUE;
        
        // Check every possible top-left corner (i,j) → bottom-right is always (n,m)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Sum from (i,j) to (n-1, m-1) — 0-based
                long current = prefix[n][m]
                             - prefix[i][m]
                             - prefix[n][j]
                             + prefix[i][j];
                
                if (current > maxSum) {
                    maxSum = current;
                }
            }
        }
        
        return maxSum;
    }
}
