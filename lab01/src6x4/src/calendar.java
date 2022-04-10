import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;


public class calendar {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("Enter a month:");
		String month = keyboard.nextLine();
		String monthList[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
				"Jan.", "Feb.", "Mar.", "Apr.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.",
				"Jan", "Feb", "Mar", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		boolean validMonth = Arrays.asList(monthList).contains(month);

		while (validMonth != true) {
			System.out.println("Please enter a valid month!");
			month = keyboard.nextLine();
			validMonth = Arrays.asList(monthList).contains(month);
		}
		
		System.out.println("Enter a year:");
		int year = keyboard.nextInt();
		while (year < 0) {
			System.out.println("Please enter a valid year!");
			year = keyboard.nextInt();
		}
		
		int day = 0;

		

		switch(month) {
		case "1":
		case "January":
		case "Jan":
		case "Jan.":
			day = 31;
			break;
		case "2":
		case "February":
		case "Feb.":
		case "Feb":
			if ((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0))) {
				day = 29;
				break;
			}
			else {
				day = 28;
				break;
			}
		case "3":
		case "March":
		case "Mar":
		case "Mar.":
			day = 31;
			break;
		case "4":
		case "April":
		case "Apr.":
		case "Apr":
			day = 30;
			break;
		case "5":
		case "May":
			day = 31;
			break;
		case "6":
		case "June":
		case "Jun":
			day = 30;
			break;
		case "7":
		case "July":
		case "Jul":
			day = 30;
			break;
		case "8":
		case "August":
		case "Aug":
		case "Aug.":
			day = 31;
			break;
		case "9":
		case "September":
		case "Sept.":
		case "Sep":
			day = 30;
			break;
		case "10":
		case "October":
		case "Oct":
		case "Oct.":
			day = 31;
			break;
		case "11":
		case "November":
		case "Nov":
		case "Nov.":
			day = 30;
			break;
		case "12":
		case "December":
		case "Dec":
		case "Dec.":
			day = 31;
			break;
		
		}
		System.out.println("Number of days: " + day);
	}
}
