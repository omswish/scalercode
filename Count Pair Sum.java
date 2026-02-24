import java.util.HashMap;

public class Solution {
    public int solve(int[] A, int B) {
        long count = 0;
        long mod = 1000000007;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : A) {
            int complement = B - num;

            // If we have seen the complement before, 
            // each occurrence forms a valid pair with the current number
            if (freqMap.containsKey(complement)) {
                count = (count + freqMap.get(complement)) % mod;
            }

            // Update the frequency of the current number in the map
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return (int) count;
    }
}
