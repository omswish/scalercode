import java.util.*;

public class Solution {
    // List to store each move as [disk, start, end]
    ArrayList<int[]> moves;

    public int[][] towerOfHanoi(int A) {
        moves = new ArrayList<>();
        
        // Towers are numbered 1, 2, and 3
        solve(A, 1, 2, 3);
        
        // Convert ArrayList to 2D array
        int[][] result = new int[moves.size()][3];
        for (int i = 0; i < moves.size(); i++) {
            result[i] = moves.get(i);
        }
        
        return result;
    }

    private void solve(int disk, int source, int helper, int destination) {
        // Base case: No disks to move
        if (disk == 0) {
            return;
        }

        // Step 1: Move top n-1 disks from source to helper
        // Destination becomes the helper for this sub-problem
        solve(disk - 1, source, destination, helper);

        // Step 2: Move the current disk from source to destination
        moves.add(new int[]{disk, source, destination});

        // Step 3: Move n-1 disks from helper to destination
        // Source becomes the helper for this sub-problem
        solve(disk - 1, helper, source, destination);
    }
}
