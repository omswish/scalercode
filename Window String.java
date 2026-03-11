public class Solution {
    public String minWindow(String A, String B) {
        int n = A.length();
        int m = B.length();
        if (n < m) return "";

        int[] reqFreq = new int[128];
        for (char c : B.toCharArray()) {
            reqFreq[c]++;
        }

        int[] windowFreq = new int[128];
        int left = 0;
        int count = 0; // Number of characters in A currently matching B's requirement
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;

        for (int right = 0; right < n; right++) {
            char curr = A.charAt(right);
            windowFreq[curr]++;

            // If the current character is needed and we haven't exceeded B's count
            if (reqFreq[curr] > 0 && windowFreq[curr] <= reqFreq[curr]) {
                count++;
            }

            // When window is valid (contains all characters of B)
            while (count == m) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    startIdx = left;
                }

                // Try to shrink from the left
                char leftChar = A.charAt(left);
                windowFreq[leftChar]--;
                
                // If removing leftChar makes the window invalid
                if (reqFreq[leftChar] > 0 && windowFreq[leftChar] < reqFreq[leftChar]) {
                    count--;
                }
                left++;
            }
        }

        if (startIdx == -1) return "";
        return A.substring(startIdx, startIdx + minLen);
    }
}
