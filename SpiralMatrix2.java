/*
Problem Description

Given an integer matrix A of size NxN. Print the matrix in spiral form starting from A[0][0] in the first row.
For example : Given matrix of 2x2
1 2
3 4
You should print => 1 2 4 3


Problem Constraints

1 <= N <= 1000
1 <= A[i] <= 109


Input Format

First line is N
Next N line contains N integers in each line


Output Format

Print matrix in spiral form in a single line


Example Input

Input 1:
2
5 2
6 8 
Input 2:
3
8 2 5 
2 9 6 
5 8 7


Example Output

Output 1:
5 2 8 6 
Output 2:
8 2 5 6 7 8 5 2 9


Example Explanation

Explanation 1:
Spiral form of given matrix is 5 -> 2 -> 8 -> 6 
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        
        int top = 0, bottom = N - 1, left = 0, right = N - 1;
        
        while (top <= bottom && left <= right) {
            // Top row: left right
            for (int j = left; j <= right; j++) {
                System.out.print(A[top][j] + " ");
            }
            top++;
            
            // Right column: top bottom
            for (int i = top; i <= bottom; i++) {
                System.out.print(A[i][right] + " ");
            }
            right--;
            
            // Bottom row: right left (only if row still exists)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(A[bottom][j] + " ");
                }
                bottom--;
            }
            
            // Left column: bottom top (only if column still exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(A[i][left] + " ");
                }
                left++;
            }
        }
        
        System.out.println();   // final newline after trailing space
        
        sc.close();
    }
}
