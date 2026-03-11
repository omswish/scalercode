public class Solution {
    public int solve(char[] A) {
        // Iterate through every character in the array
        for (int i = 0; i < A.length; i++) {
            char c = A[i];
            
            // Check if the character is NOT alphanumeric
            if (!((c >= 'a' && c <= 'z') || 
                  (c >= 'A' && c <= 'Z') || 
                  (c >= '0' && c <= '9'))) {
                // If even one character fails, return 0 immediately
                return 0;
            }
        }
        
        // If the loop finishes, all characters were valid
        return 1;
    }
}
