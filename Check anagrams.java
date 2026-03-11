public class Solution {
    public int solve(String A, String B) {
        // Since we are given each has length N, we don't need a length check,
        // but it's good practice to ensure they match.
        if (A.length() != B.length()) return 0;

        int[] freq = new int[26];

        // Process both strings in a single pass
        for (int i = 0; i < A.length(); i++) {
            freq[A.charAt(i) - 'a']++;
            freq[B.charAt(i) - 'a']--;
        }

        // Check if all counts returned to zero
        for (int count : freq) {
            if (count != 0) {
                return 0;
            }
        }

        return 1;
    }
}
