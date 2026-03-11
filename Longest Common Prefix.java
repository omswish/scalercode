public class Solution {
    public String longestCommonPrefix(String[] A) {
        if (A == null || A.length == 0) {
            return "";
        }

        // Assume the first string is the common prefix
        String prefix = A[0];

        for (int i = 1; i < A.length; i++) {
            // While the current string A[i] doesn't start with the prefix
            while (A[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, there's no common prefix at all
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
