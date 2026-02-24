import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int getSum(int A, int B, int[] C) {
        long sum = 0;
        long mod = 1000000007;
        boolean found = false;
        
        // Step 1: Count the frequency of each tree height
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int height : C) {
            freqMap.put(height, freqMap.getOrDefault(height, 0) + 1);
        }
        
        // Step 2: Sum unique heights that appear exactly B times
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == B) {
                sum = (sum + entry.getKey()) % mod;
                found = true;
            }
        }
        
        // Step 3: Return -1 if no such height exists, otherwise the sum
        return found ? (int) sum : -1;
    }
}
