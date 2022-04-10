//Java program to calculate the average of array elements
import java.util.Scanner;
import java.util.Arrays;

public class basic_arr {
    // Function that returns the average of an array.
    static double averageCalculate(int a[], int n)
    {
        // Find sum of array element
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += a[i];
        }
        System.out.println("The total sum of all the elements in the array is "+sum);
        return (double)sum / n;
    }
    //driver code
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n;  //Declare array size
        System.out.println("Enter the total number of elements in the array ");
        n = sc.nextInt();  //Initialize the array size
        
        int arr[] = new int[n];    //Declare array
        System.out.println("Enter the array elements ");
        for(int i=0;i<n;i++)      //Initialize the array
        {
            arr[i]=sc.nextInt();
        }
     
        System.out.println("The average of all the elements in an array is " + averageCalculate(arr, n));
        Arrays.sort(arr);
        System.out.printf("Sort array : %s", Arrays.toString(arr));

    }
}
 