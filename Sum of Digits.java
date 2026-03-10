public class Solution {
    public int solve(int A) {
        // Base Case: If the number is 0, the sum of digits is 0
        if (A == 0) {
            return 0;
        }
        
        // Recursive Step: 
        // Extract the last digit (A % 10) 
        // Add it to the result of the function called with the remaining digits (A / 10)
        return (A % 10) + solve(A / 10);
    }
}
