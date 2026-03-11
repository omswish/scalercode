public class Solution {
    public int solve(String A) {
        int n = A.length();
        int count = 0;

        // Loop until n-2 to ensure we have at least 3 characters to check
        for (int i = 0; i <= n - 3; i++) {
            // Check for the pattern 'b', 'o', 'b'
            if (A.charAt(i) == 'b' && 
                A.charAt(i + 1) == 'o' && 
                A.charAt(i + 2) == 'b') {
                count++;
            }
        }

        return count;
    }
}
