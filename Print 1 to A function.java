public class Solution {
    public void solve(int A) {
        // Start the recursive printing
        printNumbers(A);
        // Print the required newline after all numbers are out
        System.out.println();
    }

    private void printNumbers(int n) {
        // Base case: Stop when we reach 0
        if (n == 0) {
            return;
        }

        // Recursive call: Go down to n-1 first
        // This ensures 1 is printed first, then 2, etc.
        printNumbers(n - 1);

        // Print current number after the smaller numbers have been printed
        System.out.print(n + " ");
    }
}
