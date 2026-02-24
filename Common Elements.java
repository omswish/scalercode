import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] solve(int[] A, int[] B) {
        // Step 1: Store frequencies of elements in array A
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Identify common elements using array B
        ArrayList<Integer> commonList = new ArrayList<>();
        for (int num : B) {
            // If num exists in map and has a remaining count > 0
            if (map.containsKey(num) && map.get(num) > 0) {
                commonList.add(num);
                // Decrement the frequency to "consume" one occurrence
                map.put(num, map.get(num) - 1);
            }
        }

        // Step 3: Convert ArrayList to primitive int array
        int[] result = new int[commonList.size()];
        for (int i = 0; i < commonList.size(); i++) {
            result[i] = commonList.get(i);
        }

        return result;
    }
}
