public class Solution {
    private int start = 0;
    private int maxLen = 0;

    public String longestPalindrome(String A) {
        int n = A.length();
        if (n < 2) return A;

        for (int i = 0; i < n; i++) {
            // Check for odd length palindromes (center is at i)
            expandAroundCenter(A, i, i);
            // Check for even length palindromes (center is between i and i+1)
            expandAroundCenter(A, i, i + 1);
        }

        return A.substring(start, start + maxLen);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int currentLen = right - left + 1;
            
            if (currentLen > maxLen) {
                maxLen = currentLen;
                start = left;
            }
            // In case of a tie in length, we don't update 'start' because 
            // the problem asks for the first occurrence.
            
            left--;
            right++;
        }
    }
}
