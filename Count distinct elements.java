import java.util.HashSet;

public class Solution {
    public int solve(int[] A) {
        // Step 1: Initialize a HashSet to store unique integers
        HashSet<Integer> uniqueElements = new HashSet<>();
        
        // Step 2: Iterate through the array and add elements to the set
        for (int num : A) {
            uniqueElements.add(num);
        }
        
        // Step 3: The size of the set is the count of unique elements
        return uniqueElements.size();
    }
}
