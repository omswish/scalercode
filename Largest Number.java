import java.util.*;

public class Solution {
    public String largestNumber(int[] A) {
        int n = A.length;
        String[] strs = new String[n];
        
        // 1. Convert integers to Strings
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(A[i]);
        }

        // 2. Sort using the custom comparator
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                // We want descending order, so we compare order2 to order1
                return order2.compareTo(order1);
            }
        });

        // 3. Handle edge case: if the largest number is "0", return "0"
        // (This happens if the array is like [0, 0, 0])
        if (strs[0].equals("0")) {
            return "0";
        }

        // 4. Build the final string
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
}
