/*
Problem Description

Kamal is a software developer and he's working on a new feature for an e-commerce website. The website has a list of prices for different products, and Kamal needs to find the maximum price of all products up to a given index.

He has the list of prices in an array A of length N, and he needs to write a program that will return the maximum price occurring in the subarray from 0 to i for every index i. Kamal needs your help to implement this function.



Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109


Input Format

Only argument A is an array of integers.


Output Format

Return an array of integers where the i-th element of the array represents the maximum value occurring in the subarray from 0 to i in the input array A.


Example Input

Input 1:

A = [9, 7, 6, 18, 2]
Input 2:

A = [16, 8, 24, 9, 25, 17]


Example Output

Output 1:

[9, 9, 9, 18, 18]
Output 2:

[16, 16, 24, 24, 25, 25]


Example Explanation

Explanation 1:

The prefix maximum array of [9, 7, 6, 18, 2] is [9, 9, 9, 18, 18].
Explanation 2:

The prefix maximum array of [16, 8, 24, 9, 25, 17] is [16, 16, 24, 24, 25, 25].
*/

public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;
        if (n == 0) {
            return new int[0];
        }
        
        int[] prefixMax = new int[n];
        prefixMax[0] = A[0];           // first element is always itself
        
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], A[i]);
        }
        
        return prefixMax;
    }
}
