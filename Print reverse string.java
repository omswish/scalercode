import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Check if there is a string to read
        if (sc.hasNext()) {
            String S = sc.next();
            // Start recursion from the first character (index 0)
            reversePrint(S, 0);
            // Print a newline at the very end
            System.out.println();
        }
    }

    public static void reversePrint(String s, int index) {
        // Base Case: If we have reached the end of the string, return
        if (index == s.length()) {
            return;
        }

        // Recursive Step: Go to the next character first
        reversePrint(s, index + 1);

        // Action: Print current character as we come back up the stack
        System.out.print(s.charAt(index));
    }
}
