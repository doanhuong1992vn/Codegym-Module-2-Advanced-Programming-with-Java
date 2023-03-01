import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a:");
        double a = input.nextDouble();
        System.out.println("Enter b:");
        double b = input.nextDouble();
        System.out.println("Enter c:");
        double c = input.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        System.out.println("Your equation: " + equation.getEquation());
        if (equation.getDiscriminant() > 0) {
            System.out.println("Your equation has 2 roots: " + equation.getRoot1() + " and " + equation.getRoot2());
        } else if (equation.getDiscriminant() == 0) {
            System.out.println("Your equation has 1 root: " + equation.getRoot1());
        } else {
            System.out.println("Your equation has no root");
        }
    }
}