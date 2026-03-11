public class Solution {
    public String solve(String A) {
        StringBuilder sb = new StringBuilder();
        
        // Process the string once to handle deletion and replacement
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            
            // 1. Skip uppercase letters (effectively deleting them)
            if (c >= 'A' && c <= 'Z') {
                continue;
            }
            
            // 2. Replace lowercase vowels with '#'
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.append('#');
            } else {
                // 3. Keep lowercase consonants as they are
                sb.append(c);
            }
        }
        
        // 4. Concatenate the result with itself
        String processed = sb.toString();
        return processed + processed;
    }
}
