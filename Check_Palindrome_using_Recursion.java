public class Solution {
    public int solve(String A) {
        // Start the recursion with pointers at the beginning and end
        return isPalindrome(A, 0, A.length() - 1);
    }

    private int isPalindrome(String s, int left, int right) {
        // Base Case: If pointers cross or meet, it's a palindrome
        if (left >= right) {
            return 1;
        }

        // Check if characters at current pointers match
        if (s.charAt(left) != s.charAt(right)) {
            return 0;
        }

        // Recursive Step: Move inward
        return isPalindrome(s, left + 1, right - 1);
    }
}
