import java.util.*;

public class Solution {
    public int solve(int[][] A) {
        // Use a HashSet to store unique representations of the points
        Set<List<Integer>> uniquePoints = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            // We wrap the x and y coordinates in a List
            // Lists compare their elements, not their memory addresses
            uniquePoints.add(Arrays.asList(A[i][0], A[i][1]));
        }

        // The size of the set represents the number of unique points
        return uniquePoints.size();
    }
}
