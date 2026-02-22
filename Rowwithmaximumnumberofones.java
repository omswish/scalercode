public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int maxOnes = -1;
        int bestRow = 0;
        
        for (int i = 0; i < n; i++) {
            // Start from rightmost column
            int j = n - 1;
            while (j >= 0 && A.get(i).get(j) == 1) {
                j--;
            }
            // number of 1's = (n - 1 - j)
            int ones = n - 1 - j;
            
            if (ones > maxOnes) {
                maxOnes = ones;
                bestRow = i;
            }
        }
        
        return bestRow;
    }
}
