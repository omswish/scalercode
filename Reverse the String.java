public class Solution {
    public String solve(String A) {
        if (A == null) return "";

        // 1. Trim leading and trailing spaces
        A = A.trim();
        
        // 2. Split by one or more spaces ("\\s+" is the regex for multiple spaces)
        String[] words = A.split("\\s+");
        
        StringBuilder result = new StringBuilder();

        // 3. Build the result by iterating backwards through the words
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            
            // Append a space between words, but not after the last word
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
