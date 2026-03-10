import java.util.Arrays;

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        if (n <= 1) return 0;

        // 1. Sort the array O(N log N)
        Arrays.sort(A);

        long steps = 0;

        // 2. Iterate through the array and ensure each element is > previous
        for (int i = 1; i < n; i++) {
            if (A[i] <= A[i - 1]) {
                // Calculate how much we need to increase A[i]
                int newValue = A[i - 1] + 1;
                steps += (newValue - A[i]);
                
                // Update the current element to its new unique value
                A[i] = newValue;
            }
        }

        return (int) steps;
    }
}
