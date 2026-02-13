/*
Problem Description

There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B


Problem Constraints

1 <= A <= 2 * 105
1 <= L <= R <= A
1 <= P <= 103
0 <= len(B) <= 105


Input Format

The first argument is a single integer A.
The second argument is a 2D integer array B.


Output Format

Return an array(0 based indexing) that stores the total number of coins in each beggars pot.
*/



public class Solution {
    public int[] solve(int A, int[][] B) {
        // Step 1: Create difference array of size A+2 (1-based indexing safety)
        long[] diff = new long[A + 2];
        
        // Step 2: For each donation range update using difference array
        for (int[] donation : B) {
            int L = donation[0];    // 1-based
            int R = donation[1];
            int P = donation[2];
            
            // Add P at start of range
            diff[L] += P;
            
            // Subtract P after end of range (to cancel out after R)
            diff[R + 1] -= P;
        }
        
        // Step 3: Compute prefix sum to get final amount for each beggar
        int[] result = new int[A];
        long current = 0;
        
        for (int i = 1; i <= A; i++) {
            current += diff[i];           // accumulate the updates
            result[i - 1] = (int) current; // 0-based indexing
        }
        
        return result;
    }
}
