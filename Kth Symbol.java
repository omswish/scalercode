public class Solution {
    public int solve(int A, int B) {
        // Base case: Row 1 is always 0
        if (A == 1) {
            return 0;
        }

        // Calculate the midpoint of the current row
        // Row A has 2^(A-1) elements, so the midpoint is 2^(A-2)
        long mid = (long) Math.pow(2, A - 2);

        if (B < mid) {
            // If B is in the first half, it's the same as the previous row
            return solve(A - 1, B);
        } else {
            // If B is in the second half, it's the complement of the previous row
            // We flip 0 to 1 and 1 to 0 using (1 - result)
            return 1 - solve(A - 1, (int)(B - mid));
        }
    }
}
