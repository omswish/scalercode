import java.util.HashMap;

public class Solution {
    public int solve(int[] A, int B) {
        long count = 0;
        long mod = 1000000007;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Build the frequency map
        for (int num : A) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Iterate through the map to find pairs
        for (int x : freqMap.keySet()) {
            // We look for y such that y - x = B  => y = x + B
            // Using long to prevent overflow before modulo
            long countX = freqMap.get(x);

            if (B == 0) {
                // If B is 0, we need two of the same number: nC2 formula
                count = (count + (countX * (countX - 1)) / 2) % mod;
            } else {
                // Check if x + B exists in the map
                // We only check in one direction (x + B) to avoid double counting
                int target = x + B;
                if (freqMap.containsKey(target)) {
                    long countTarget = freqMap.get(target);
                    count = (count + (countX * countTarget)) % mod;
                }
            }
        }

        return (int) count;
    }
}
