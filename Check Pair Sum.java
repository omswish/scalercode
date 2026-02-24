import java.util.HashSet;

public class Solution {
    public int solve(int A, int[] B) {
        // HashSet to store the elements we have visited
        HashSet<Integer> seen = new HashSet<>();

        for (int num : B) {
            int complement = A - num;

            // If the complement exists in the set, we found the pair
            if (seen.contains(complement)) {
                return 1;
            }

            // Otherwise, add the current number to the set
            seen.add(num);
        }

        // No pair found after checking all elements
        return 0;
    }
}
