public class Solution {
    public String solve(String A) {
        char[] chars = A.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            
            // Check if character is Uppercase
            if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) (c + 32);
            } 
            // Check if character is Lowercase
            else if (c >= 'a' && c <= 'z') {
                chars[i] = (char) (c - 32);
            }
        }
        
        return new String(chars);
    }
}
