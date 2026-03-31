public class Solution {
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        // Use HashSet for O(1) average time lookups
        HashSet<String> dictionary = new HashSet<>(A);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // For each word in B, check if it exists in dictionary
        for (String word : B) {
            if (dictionary.contains(word)) {
                result.add(1);
            } else {
                result.add(0);
            }
        }
        
        return result;
    }
}
