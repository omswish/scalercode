import java.util.Scanner;

public class CircleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = input.nextDouble();

        // Calculations
        double diameter = 2 * radius;
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * Math.pow(radius, 2);

        // Output results
        System.out.println("\n--- Results ---");
        System.out.printf("Radius:        %.2f%n", radius);
        System.out.printf("Diameter:      %.2f%n", diameter);
        System.out.printf("Circumference: %.2f%n", circumference);
        System.out.printf("Area:          %.2f%n", area);

        input.close();
    }
}
