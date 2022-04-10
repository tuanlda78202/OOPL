import java.util.Scanner;

public class solve_eq {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What's equation you wanna solve ? \n - Linear 1 variable input '1' \n - System Linear 2 variables input '2' \n - 2-degree equation 1 variable input '3' ");
		int var = input.nextInt();
		if (var == 1) {
			// one variable
			System.out.println("Input a: ");
			double a = input.nextInt();
			System.out.println("Input b: ");
			double b = input.nextInt();
			if (a != 0) {
				double result = -b/a;
				System.out.println("Solution is: x = " + result);
			}
			else {
				if (b == 0) {
					System.out.println("Inf solution !");
				}
				else {
					System.out.println("No solution !");
				}
			}
		}
		else if (var == 2) {
			// two variables
			System.out.println("Input a1: ");
			double a1 = input.nextInt();
			System.out.println("Input b1: ");
			double b1 = input.nextInt();
			System.out.println("Input c1: ");
			double c1 = input.nextInt();
			System.out.println("Input a2: ");
			double a2 = input.nextInt();
			System.out.println("Input b2: ");
			double b2 = input.nextInt();
			System.out.println("Input c2: ");
			double c2 = input.nextInt();
			double D = a1 * b2 - a2 * b1;
			double Dx = c1 * b2 - c2 * b1;
			double Dy = a1 * c2 - a2 * c1;
			if (D != 0) {
				double x = Dx/D;
				double y = Dy/D;
				System.out.println("Solution: x = " + x + " & y = " + y);
			}
			else {
				if (Dx != 0) {
					System.out.println("No solution !");
				}
				else {
					System.out.println("Inf solution with form: \n x = t; y = (" + c1 + "-" + a1 + "x)/" + b1);
				}
			}
		}
		else if (var == 3) {
			System.out.println("Input a: ");
			double a = input.nextInt();
			System.out.println("Input b: ");
			double b = input.nextInt();
			System.out.println("Input c: ");
			double c = input.nextInt();
			if (a == 0 && b == 0 && c == 0) {
				System.out.println("Inf solution !");
			}
			else if (a == 0 && b == 0 && c != 0) {
				System.out.println("No solution !");
			}
			else if (a == 0 && b != 0) {
				System.out.println("Solution is: For all x, y =" + c/b);
			}
			else if (a != 0) {
				double delta = Math.pow(b, 2) - 4 * a * c;
				if (delta < 0) {
					System.out.println("No solution !");
				}
				else if (delta == 0) {
					System.out.println("Double root: x = " + b/(2*a));
				}
				else {
					double x1 = (-b - Math.sqrt(delta))/(2*a);
					double x2 = (-b + Math.sqrt(delta))/(2*a);
					System.out.println("2 Distinct root: \n" + "x1 = " + x1 + "\n x2 = " + x2);
				}
			}
		}
		
		
		
		
		
	}

}