public class Solution {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int count = 0;

        if (n > m) return 0;

        int[] freqA = new int[26];
        int[] freqB = new int[26];

        // 1. Fill frequency for A and the first window of B
        for (int i = 0; i < n; i++) {
            freqA[A.charAt(i) - 'a']++;
            freqB[B.charAt(i) - 'a']++;
        }

        // 2. Initial check
        if (isMatch(freqA, freqB)) {
            count++;
        }

        // 3. Slide the window across string B
        for (int i = n; i < m; i++) {
            // Add current character to window
            freqB[B.charAt(i) - 'a']++;
            // Remove the character that is no longer in the window
            freqB[B.charAt(i - n) - 'a']--;

            if (isMatch(freqA, freqB)) {
                count++;
            }
        }

        return count;
    }

    // Helper method to compare two frequency arrays
    private boolean isMatch(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
