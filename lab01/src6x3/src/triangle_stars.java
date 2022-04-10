import java.util.Scanner;

public class triangle_stars {
    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Height of triangle ?");
      int height = keyboard.nextInt();

      int rows = height, k = 0;
  
      for (int i = 1; i <= rows; ++i, k = 0) {
        for (int space = 1; space <= rows - i; ++space) {
          System.out.print("  ");
        }
  
        while (k != 2 * i - 1) {
          System.out.print("* ");
          ++k;
        }
  
        System.out.println();
      }
    }
  }