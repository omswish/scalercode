public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        long total = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                long count = (long)(r + 1) * (n - r) * (c + 1) * (n - c);
                total += count * A.get(r).get(c);
            }
        }
        
        return (int) total;
    }
}
