import java.util.Arrays;

public class Solution {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int left = 0;
        int right = 0;
        long currentSum = 0;

        while (right < n) {
            // Expand the window by adding the element at the right pointer
            currentSum += A[right];

            // Shrink the window from the left if currentSum is too large
            while (currentSum > B && left < right) {
                currentSum -= A[left];
                left++;
            }

            // Check if we've hit the target sum
            if (currentSum == B) {
                // Construct the result array from index left to right
                int[] result = new int[right - left + 1];
                for (int i = 0; i < result.length; i++) {
                    result[i] = A[left + i];
                }
                return result;
            }
            
            right++;
        }

        // If no subarray is found, return [-1]
        return new int[]{-1};
    }
}
