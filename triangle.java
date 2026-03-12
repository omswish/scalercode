import java.util.Scanner;

public class TriangleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--- Triangle Calculator ---");
        System.out.println("1. Area using Base and Height");
        System.out.println("2. Area and Perimeter using Three Sides (Heron's Formula)");
        System.out.print("Select an option: ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter Base: ");
            double base = input.nextDouble();
            System.out.print("Enter Height: ");
            double height = input.nextDouble();

            double area = 0.5 * base * height;
            System.out.printf("The Area is: %.2f%n", area);

        } else if (choice == 2) {
            System.out.print("Enter side a: ");
            double a = input.nextDouble();
            System.out.print("Enter side b: ");
            double b = input.nextDouble();
            System.out.print("Enter side c: ");
            double c = input.nextDouble();

            // Perimeter
            double perimeter = a + b + c;

            // Semi-perimeter for Heron's Formula
            double s = perimeter / 2;
            
            // Check if it's a valid triangle
            double radicand = s * (s - a) * (s - b) * (s - c);
            
            if (radicand > 0) {
                double area = Math.sqrt(radicand);
                System.out.printf("Perimeter: %.2f%n", perimeter);
                System.out.printf("Area (Heron's): %.2f%n", area);
            } else {
                System.out.println("Error: These side lengths do not form a valid triangle.");
            }
        } else {
            System.out.println("Invalid selection.");
        }

        input.close();
    }
}
