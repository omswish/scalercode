public class Solution {
    public int solve(final String A, final String B) {
        String concat = B + "$" + A;
        int n = concat.length();
        int patternLen = B.length();
        int[] Z = new int[n];
        
        // Z-array construction
        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i <= R) {
                Z[i] = Math.min(R - i + 1, Z[i - L]);
            }
            while (i + Z[i] < n && concat.charAt(Z[i]) == concat.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > R) {
                L = i;
                R = i + Z[i] - 1;
            }
        }
        
        // Count occurrences
        int count = 0;
        for (int i = patternLen + 1; i < n; i++) {
            if (Z[i] == patternLen) {
                count++;
            }
        }
        
        return count;
    }
}
