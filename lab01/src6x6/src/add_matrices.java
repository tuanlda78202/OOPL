import java.util.Scanner;

public class add_matrices {

	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number of rows: ");
		int rows = input.nextInt();
		System.out.println("Enter the number of columns: ");
		int cols = input.nextInt();
		
		double arr1[][] = new double[rows][cols];
		double arr2[][] = new double[rows][cols];
		
		System.out.println("Enter the number of the 1st matrix: ");
		for ( int r=0; r<rows; r++) {
			for (int c = 0; c < cols; c++) {
				arr1[r][c] = input.nextDouble();
			}
		}
		
		System.out.println("Enter the number of the 2nd matrix: ");
		for ( int r=0; r<rows; r++) {
			for (int c = 0; c < cols; c++) {
				arr2[r][c] = input.nextDouble();
			}
		}
		
		double sum[][] = new double[rows][cols];
		for ( int r=0; r<rows; r++) {
			for (int c = 0; c < cols; c++) {
				sum[r][c] = arr1[r][c] + arr2[r][c];
			}
		}
		
		
		System.out.println("The sum of the two matrices is: ");
		for ( int r=0; r<rows; r++) {
			for (int c = 0; c < cols; c++) {
				System.out.print(sum[r][c] + "\t");
			}
			System.out.print("\n");
		}


	}

}