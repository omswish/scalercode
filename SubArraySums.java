import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        // Generate and print all subarray sums
        for (int i = 0; i < N; i++) {
            long sum = 0;   // using long to prevent overflow (though constraint allows int)
            for (int j = i; j < N; j++) {
                sum += A[j];
                if (i == 0 && j == 0) {
                    System.out.print(sum);
                } else {
                    System.out.print(" " + sum);
                }
            }
        }
        
        System.out.println();   // new line at the end
        
        sc.close();
    }
}
