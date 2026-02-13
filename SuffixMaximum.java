/*
Problem Description

Given an array A of length N, For every index i, you need to find the maximum value in subarray from i to N-1.


Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109


Input Format

Only argument A is an array of integers.


Output Format

Return an array of integers denoting the suffix maximum of the given array.


Example Input

Input 1:

A = [12, 5, 6, 7]
Input 2:

A = [15, 9, 7, 11, 10]


Example Output

Output 1:

[12, 7, 7, 7]
Output 2:

[15, 11, 11, 11, 10]


Example Explanation

Explanation 1:

The suffix maximum array of [12, 5, 6, 7]] is [12, 7, 7, 7].
Explanation 2:

The suffix maximum array of [15, 9, 7, 11, 10] is [15, 11, 11, 11, 10].
*/


public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;
        if (n == 0) {
            return new int[0];
        }
        
        int[] suffixMax = new int[n];
        suffixMax[n-1] = A[n-1];           // last element is always itself
        
        for (int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], A[i]);
        }
        
        return suffixMax;
    }
}
