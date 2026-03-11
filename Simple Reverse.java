public class Solution {
    public String solve(String A) {
        if (A == null || A.length() <= 1) {
            return A;
        }

        char[] chars = A.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Swap characters
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move pointers
            left++;
            right--;
        }

        return new String(chars);
    }
}
