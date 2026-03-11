public class Solution {
    public char[] to_lower(char[] A) {
        for (int i = 0; i < A.length; i++) {
            // Check if the current character is an Uppercase letter
            if (A[i] >= 'A' && A[i] <= 'Z') {
                // Convert to lowercase by adding 32
                // We cast back to char because addition results in an int
                A[i] = (char) (A[i] + 32);
            }
        }
        return A;
    }
}
