/*
Problem Description

Given an matrix A of size NxN, which is row-wise and column-wise sorted. Find if the number B exists in the matrix.

Note :
0 represents False and 1 represents True


Problem Constraints

1 <= N <= 103
-105 <= A[i][j] <= 105


Input Format

First argument A is an matrix of integers.
Second argument is B.


Output Format

Return a boolean value stating if the number exists or not


Example Input

Input 1:

A = [[1, 5, 6],
[4, 8, 11],
[7, 9, 14]]
B = 14
Input 2:

A = [[4, 10],
[4, 12]]
B = 5


Example Output

Output 1:

True
Output 2:

False


Example Explanation

Explanation 1:

14 is found at the last index in the matrix.
Explanation 2:

5 is not present in the matrix.



Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
*/
public class Solution {
    public int solve(int[][] A, int B) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        
        int n = A.length;
        int m = A[0].length;
        
        // Start from top-right corner
        int i = 0;          // row
        int j = m - 1;      // column
        
        while (i < n && j >= 0) {
            if (A[i][j] == B) {
                return 1;   // found
            }
            else if (A[i][j] > B) {
                // current element is too big  move left (smaller values)
                j--;
            }
            else {
                // current element is too small  move down (bigger values)
                i++;
            }
        }
        
        return 0;   // not found
    }
}
