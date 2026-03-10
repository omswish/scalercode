import java.util.Arrays;

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        if (n <= 1) return 1;

        // 1. Find Min and Max
        int min = A[0];
        int max = A[0];
        for (int x : A) {
            if (x < min) min = x;
            if (x > max) max = x;
        }

        // 2. Check Range Rule
        if (max - min != n - 1) {
            return 0;
        }

        // 3. Check Uniqueness Rule (O(1) extra space via in-place sort)
        Arrays.sort(A);
        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1]) {
                return 0;
            }
        }

        return 1;
    }
}
