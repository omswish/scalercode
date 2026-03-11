import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] A, int B) {
        // Sort the array to enable the two-pointer approach
        Arrays.sort(A);
        int n = A.length;
        
        // Initialize with the sum of the first three elements
        long closestSum = (long) A[0] + A[1] + A[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long currentSum = (long) A[i] + A[left] + A[right];

                // If this sum is closer to B than our best found so far, update it
                if (Math.abs(currentSum - B) < Math.abs(closestSum - B)) {
                    closestSum = currentSum;
                }

                if (currentSum < B) {
                    left++; // Need a larger sum
                } else if (currentSum > B) {
                    right--; // Need a smaller sum
                } else {
                    // Found exact match
                    return (int) currentSum;
                }
            }
        }

        return (int) closestSum;
    }
}
