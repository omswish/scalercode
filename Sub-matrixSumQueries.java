/*
Problem Description

Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.




Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom, and columns are numbered from left to right.
The sum may be large, so return the answer mod 109 + 7.
Also, select the data type carefully, if you want to store the addition of some elements.
Indexing given in B, C, D, and E arrays is 1-based.
Top Left 0-based index = (B[i] - 1, C[i] - 1)
Bottom Right 0-based index = (D[i] - 1, E[i] - 1)




Problem Constraints

1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M



Input Format

The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.



Output Format

Return an integer array containing the submatrix sum for each query.



Example Input

Input 1:

 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]
Input 2:

 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]


Example Output

Output 1:

 [12, 28]
Output 2:

 [22, 19]


Example Explanation

Explanation 1:

 For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
Explanation 2:

 For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 



Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
*/

public class Solution {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = A.length;
        int m = A[0].length;
        int q = B.length;
        
        final long MOD = 1000000007;
        
        // Step 1: Create 2D prefix sum array (1-based indexing for simplicity)
        long[][] prefix = new long[n + 1][m + 1];
        
        // Build prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = (prefix[i-1][j] + prefix[i][j-1] 
                              - prefix[i-1][j-1] + A[i-1][j-1] + MOD) % MOD;
            }
        }
        
        // Step 2: Answer each query using prefix sum formula
        int[] result = new int[q];
        
        for (int i = 0; i < q; i++) {
            // Convert 1-based to 0-based for clarity, but we use 1-based prefix
            int r1 = B[i];     // top row (1-based)
            int c1 = C[i];     // left column (1-based)
            int r2 = D[i];     // bottom row (1-based)
            int c2 = E[i];     // right column (1-based)
            
            long sum = prefix[r2][c2] 
                     - prefix[r1-1][c2] 
                     - prefix[r2][c1-1] 
                     + prefix[r1-1][c1-1];
                     
            // Handle negative values (because of mod)
            sum = (sum % MOD + MOD) % MOD;
            
            result[i] = (int) sum;
        }
        
        return result;
    }
}
