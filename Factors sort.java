import java.util.*;

public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;
        
        // Convert to Integer array to use custom Comparator
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = A[i];
        }

        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                int f1 = countFactors(n1);
                int f2 = countFactors(n2);
                
                if (f1 != f2) {
                    return f1 - f2;
                }
                // Tie-breaker: smaller value comes first
                return n1 - n2;
            }
        });

        // Copy back to primitive array
        for (int i = 0; i < n; i++) {
            A[i] = temp[i];
        }
        
        return A;
    }

    private int countFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count += 1; // Perfect square case
                } else {
                    count += 2; // i and n/i
                }
            }
        }
        return count;
    }
}
