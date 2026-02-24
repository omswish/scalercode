import java.util.HashMap;

public class Solution {
    public int solve(int[] A, int B) {
        // Map to store (Prefix Sum, Number of times it has occurred)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once (before any elements)
        map.put(0, 1);
        
        int currentSum = 0;
        int totalCount = 0;
        
        for (int num : A) {
            currentSum += num;
            
            // If (currentSum - B) exists in the map, it means there are 
            // subarrays ending here that sum to B.
            int target = currentSum - B;
            if (map.containsKey(target)) {
                totalCount += map.get(target);
            }
            
            // Update the map with the current prefix sum
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return totalCount;
    }
}
