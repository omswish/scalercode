import java.util.Arrays;

public class Solution {
    public int[] wave(int[] A) {
        // 1. Sort the array to ensure lexicographical smallest order
        Arrays.sort(A);

        // 2. Iterate through the array in steps of 2
        // Swap A[i] with A[i+1]
        for (int i = 0; i < A.length - 1; i += 2) {
            int temp = A[i];
            A[i] = A[i + 1];
            A[i + 1] = temp;
        }

        return A;
    }
}
