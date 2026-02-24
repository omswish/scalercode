import java.util.HashMap;

public class Solution {
    public int[] solve(int[] A, int[] B) {
        // 1. Initialize a HashMap to store the frequency of each learner in A
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // 2. Fill the map with counts from array A
        for (int learner : A) {
            frequencyMap.put(learner, frequencyMap.getOrDefault(learner, 0) + 1);
        }
        
        // 3. Prepare the result array based on the queries in B
        int[] result = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int queryLearner = B[i];
            // If the learner exists in the map, get their count; otherwise, 0
            result[i] = frequencyMap.getOrDefault(queryLearner, 0);
        }
        
        return result;
    }
}
