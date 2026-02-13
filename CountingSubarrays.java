public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;

        // Start index of the subarray
        for (int i = 0; i < n; i++) {
            long currentSum = 0;
            
            // End index of the subarray
            for (int j = i; j < n; j++) {
                currentSum += A[j];
                
                // Calculate the length of the current subarray
                int length = j - i + 1;

                // Check Criteria 1: Even length and Sum < B
                if (length % 2 == 0) {
                    if (currentSum < B) {
                        count++;
                    }
                } 
                // Check Criteria 2: Odd length and Sum > B
                else {
                    if (currentSum > B) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
