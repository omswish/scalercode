import java.util.HashMap;

public class Solution {
    public int solve(int[] A) {
        long count = 0;
        long mod = 1000000007;
        long currentPrefixSum = 0;
        
        // Map to store the frequency of each prefix sum
        HashMap<Long, Integer> freqMap = new HashMap<>();
        
        // Base case: a prefix sum of 0 has been seen once (empty subarray)
        freqMap.put(0L, 1);
        
        for (int num : A) {
            currentPrefixSum += num;
            
            // If this prefix sum has been seen before, it forms 'freq' number of zero-sum subarrays
            if (freqMap.containsKey(currentPrefixSum)) {
                int freq = freqMap.get(currentPrefixSum);
                count = (count + freq) % mod;
                freqMap.put(currentPrefixSum, freq + 1);
            } else {
                freqMap.put(currentPrefixSum, 1);
            }
        }
        
        return (int) count;
    }
}
