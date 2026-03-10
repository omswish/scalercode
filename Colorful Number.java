import java.util.*;

public class Solution {
    public int colorful(int A) {
        String s = String.valueOf(A);
        int n = s.length();
        Set<Long> products = new HashSet<>();

        // i is the starting point of the subsequence
        for (int i = 0; i < n; i++) {
            long currentProduct = 1;
            
            // j is the ending point of the subsequence
            for (int j = i; j < n; j++) {
                // Get the digit at current position
                int digit = s.charAt(j) - '0';
                
                // Update product for the subsequence s[i...j]
                currentProduct *= digit;

                // If product already exists, it's not a COLORFUL number
                if (products.contains(currentProduct)) {
                    return 0;
                }
                
                products.add(currentProduct);
            }
        }

        return 1;
    }
}
