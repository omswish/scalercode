public class Solution {
    public char[] to_upper(char[] A) {
        for (int i = 0; i < A.length; i++) {
            // Check if the current character is a lowercase letter
            if (A[i] >= 'a' && A[i] <= 'z') {
                // Subtract 32 to move from lowercase to uppercase in ASCII
                A[i] = (char) (A[i] - 32);
            }
            // If it's already uppercase or a special character, do nothing
        }
        return A;
    }
}
