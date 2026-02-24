import java.util.HashMap;

public class Solution {
    public int solve(int[] A) {
        // Map stores the element as key and its most recent index as value
        HashMap<Integer, Integer> lastSeen = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            int currentNum = A[i];

            if (lastSeen.containsKey(currentNum)) {
                // Calculate distance from the previous occurrence
                int distance = i - lastSeen.get(currentNum);
                minDistance = Math.min(minDistance, distance);
            }

            // Update the map with the latest index for this number
            lastSeen.put(currentNum, i);
        }

        // If minDistance was never updated, no special pair exists
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}
