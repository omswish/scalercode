import java.util.Arrays;

public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        int i = 0;
        int j = 1;
        int count = 0;

        while (j < n) {
            // Ensure i and j are never the same index
            if (i == j) {
                j++;
                continue;
            }

            int diff = A[j] - A[i];

            if (diff == B) {
                count++;
                
                // Store current values to skip all their duplicates
                int valI = A[i];
                int valJ = A[j];
                
                while (i < n && A[i] == valI) i++;
                while (j < n && A[j] == valJ) j++;
                
            } else if (diff < B) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }
}
