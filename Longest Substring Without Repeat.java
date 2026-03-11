import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String A) {
        int n = A.length();
        if (n <= 1) return n;

        // lastSeen[char] stores the last index where the character was found
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1);

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char currentChar = A.charAt(right);

            // If we've seen this char and it's inside the current window
            if (lastSeen[currentChar] >= left) {
                // Move the left pointer to skip the previous occurrence
                left = lastSeen[currentChar] + 1;
            }

            // Update the last seen position of the character
            lastSeen[currentChar] = right;

            // Update the global maximum goodness
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
