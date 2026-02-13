/*
Problem Description

Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.

In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.



Problem Constraints

1 <= N <= 106
-1000 <= A[i] <= 1000



Input Format

The first and the only argument contains an integer array, A.



Output Format

Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input

Input 1:

 A = [1, 2, 3, 4, -10] 
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 


Example Output

Output 1:

 10 
Output 2:

 6 


Example Explanation

Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
        
        for (int i = 1; i < A.length; i++) {
            // Decide whether to extend current subarray or start new one
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            
            // Update global maximum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}
