import java.util.HashMap;

public class Solution {
    public int solve(int[] A) {
        // Step 1: Store frequencies of all elements
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : A) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Step 2: Iterate through the array again to find the first 
        // element that has a frequency > 1
        for (int num : A) {
            if (counts.get(num) > 1) {
                return num;
            }
        }

        // Step 3: If no element repeats, return -1
        return -1;
    }
}
