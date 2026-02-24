import java.util.HashSet;

public class Solution {
    public int solve(int[] A, int B) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : A) {
            // We are looking for X and Y such that X - Y = B
            // This means X = Y + B OR Y = X - B
            if (set.contains(num - B) || set.contains(num + B)) {
                return 1;
            }
            
            // Add current number to set to be used as a 'partner' for future numbers
            set.add(num);
        }

        return 0;
    }
}
