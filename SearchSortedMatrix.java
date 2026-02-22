public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        if (A == null || A.isEmpty() || A.get(0).isEmpty()) {
            return -1;
        }
        
        int n = A.size();        // rows
        int m = A.get(0).size(); // columns
        
        int i = 0;               // start at top row
        int j = m - 1;           // start at rightmost column
        
        int result = -1;
        
        while (i < n && j >= 0) {
            int val = A.get(i).get(j);
            
            if (val == B) {
               
                int pos = (i + 1) * 1009 + (j + 1);
                
                
                if (result == -1 || pos < result) {
                    result = pos;
                }
              
                j--;
            }
            else if (val < B) {
                
                i++;
            }
            else {
                
                j--;
            }
        }
        
        return result;
    }
}
