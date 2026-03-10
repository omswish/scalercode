public class Solution {
    public int solve(int A) {
        if (A == 0) return 0;
        
        // If A % 9 is 1, it is a magic number
        if (A % 9 == 1) {
            return 1;
        }
        return 0;
    }
}
