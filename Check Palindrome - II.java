public class Solution {
    public int solve(String A) {
        int[] freq = new int[26];
        
        // Step 1: Count character frequencies
        for (int i = 0; i < A.length(); i++) {
            freq[A.charAt(i) - 'a']++;
        }
        
        // Step 2: Count how many characters appear an odd number of times
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // Step 3: At most one character can have an odd frequency
        return (oddCount <= 1) ? 1 : 0;
    }
}
