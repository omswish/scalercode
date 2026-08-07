public class Solution {
    public String[] solve(int[] A) {
        String[] ans = new String[A.length];
        
        for (int i = 0; i < A.length; i++) {
            int remainder = A[i] % 7;
            if (remainder == 0 || remainder == 1) {
                ans[i] = "Bob";
            } else {
                ans[i] = "Alice";
            }
        }
        
        return ans;
    }
}
