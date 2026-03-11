import java.util.*;

public class Solution {
    public int solve(String A, int B) {
        // 1. Count frequencies of each character
        int[] freq = new int[26];
        for (char c : A.toCharArray()) {
            freq[c - 'a']++;
        }

        // 2. Collect non-zero frequencies
        List<Integer> counts = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) {
                counts.add(f);
            }
        }

        // 3. Sort frequencies to remove the rarest characters first
        Collections.sort(counts);

        int distinctCharacters = counts.size();
        
        // 4. Greedy removal
        for (int count : counts) {
            if (B >= count) {
                B -= count;
                distinctCharacters--;
            } else {
                // Cannot fully remove this character or any subsequent (more frequent) ones
                break;
            }
        }

        // Special case: If B was large enough to remove everything, 
        // there should still be at least 1 character if N > 0, 
        // but based on logic, distinctCharacters would be 0.
        // However, we must change them "to any other character," 
        // so if the string becomes empty or fully replaced, 
        // the minimum possible distinct characters is 1 (unless B was exactly N and the problem allows empty).
        // Most platforms expect 1 as the minimum if at least one character remains.
        return Math.max(distinctCharacters, 1);
    }
}
