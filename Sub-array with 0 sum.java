import java.util.HashSet;

public class Solution {
    public int solve(int[] A) {
        // Use a Set to store prefix sums
        HashSet<Long> set = new HashSet<>();
        long currentPrefixSum = 0;

        for (int num : A) {
            currentPrefixSum += num;

            // Case 1: The current prefix sum is 0
            // Case 2: The prefix sum has been seen before
            if (currentPrefixSum == 0 || set.contains(currentPrefixSum)) {
                return 1;
            }

            // Add the current prefix sum to the set for future checks
            set.add(currentPrefixSum);
        }

        // If we finish the loop without finding a zero-sum, return 0
        return 0;
    }
}
