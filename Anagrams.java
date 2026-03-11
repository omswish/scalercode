import java.util.*;

public class Solution {
    public int[][] anagrams(final String[] A) {
        // Map to store sorted string as key and list of 1-based indices as value
        // LinkedHashMap preserves the insertion order of the groups
        Map<String, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < A.length; i++) {
            // 1. Sort the string to get the canonical key
            char[] charArray = A[i].toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            // 2. Add the 1-based index to the map
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            map.get(sortedKey).add(i + 1);
        }

        // 3. Convert Map values to 2D array
        int[][] result = new int[map.size()][];
        int rowIndex = 0;
        for (List<Integer> list : map.values()) {
            int[] group = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                group[j] = list.get(j);
            }
            result[rowIndex++] = group;
        }

        return result;
    }
}
