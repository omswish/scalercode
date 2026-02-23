public class Solution {
    public int solve(int A, int B) {
        if ((A & (1 << B)) != 0) {
            return 1;   // B-th bit is set
        }
        return 0;       // B-th bit is unset
    }
}
