import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solve(int[] A) {
        // Step 1: Create a frequency map for all elements in A
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num : A) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Count how many elements have a frequency of exactly 1
        int count = 0;
        for (int frequency : freqMap.values()) {
            if (frequency == 1) {
                count++;
            }
        }
        
        return count;
    }
}
