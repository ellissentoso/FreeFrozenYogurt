/*______________________________________________________________________________________________*/
/*  Name: Ellis Sentoso
 *  Instructor: Dave Harden
 *  Assignment: Lab 4 - Rewards System for Free Frozen Yogurt
 *  Description: Rewards System for Free Frozen Yogurt that reward customer with a stamp 
 *  			 for each yogurt bought. 7 stamps equates to 1 free yogurt. 
 *  Email: ellissentoso@gmail.com
 *  Date: 07/17/2019  
/*______________________________________________________________________________________________*/
package assignment4;
import java.util.Scanner;  // Import the Scanner class

public class Foothill {

	static final int REDEEM = 7; // points needed to get 1 free yogurt

	public static void main(String[] args) {
		// declare some string variables
		String userAnswer;
		String question;
		String menuAnswer;

		int stamp, yogurtNum, purchaseCount, y_n_answer;
		char redeemAnswer;

		boolean goAgain = true;

		// initalize to 0
		stamp = 0;
		yogurtNum = 0;
		purchaseCount= 0;
		y_n_answer = 0;

		Scanner input = new Scanner(System.in);  // Create a Scanner object

		// Showing menu to the user
		System.out.println("Menu: \n" + "P (process Purchase)\n" + "S (Shut down) \n");
		menuAnswer = input.nextLine(); // Taking input from the user

		while (goAgain) {
			if ((menuAnswer.charAt(0) == 'p') || (menuAnswer.charAt(0) == 'P')) {
				System.out.println("You have " + stamp + " credit");

				if (stamp < REDEEM) { // If the customer has less than points needed for a free yogurt
					// normal transaction is being executed
					do {
						// Ensure only value # of yogurt is allowed
						System.out.println("How many yogurts would you like to buy ? \n");
						yogurtNum = input.nextInt();
					} while (yogurtNum < 0 || yogurtNum > 100);
					for (int i = 0; i < yogurtNum; i++) { // count of yogurt and adjust stamps
						stamp++;					      // count accordingly
					}
					purchaseCount++;
				}
				else { // If the customer has 7 points of more for a free yogurt
					// award transaction is executed
					System.out.println("Woudl you like to redeem your award? (Y/N) \n");
					redeemAnswer = input.next().charAt(0); // storing char answer to char 
					if (redeemAnswer == 'Y' || redeemAnswer == 'y') {
						stamp -= REDEEM;

					} 
					else if (redeemAnswer == 'n' || redeemAnswer == 'N'){ // Proceeding to normal transaction
						System.out.println("How many yogurts would you like to buy ? \n");
						yogurtNum = input.nextInt();
						if (yogurtNum < 0 || yogurtNum > 100) { // range of 0 to 100 yogurt
							
								System.out.println("****** Invalid Number *******");
								System.out.println("How many yogurts would you like to buy ? \n");
								yogurtNum = input.nextInt();
						}
						for (int i = 0; i < yogurtNum; i++) { // count of yogurt and adjust stamps
							stamp++;					      // count accordingly
						}
						purchaseCount++;
					}// Out of Bound of Choice Answer Handling. (Error Handling)
					else {	
						System.out.println("****** Invalid Choice of Character *******");
						System.out.println("Press either lowercase/uppercase Y or N only \n");
						redeemAnswer = input.next().charAt(0); // storing char answer to char 
						if (redeemAnswer == 'Y' || redeemAnswer == 'y') {
							stamp -= REDEEM;
						}
					}

				}

			}
			else {
				break; // Break out of the program when user says to shut off or no more purchase
			}
			// Final Result Display
			System.out.println("Total number of stamps earned: " + stamp); // stamps earned
			System.out.println("Transaction " + purchaseCount); // Number of transaction being done
			System.out.println("Want to make another transaction?\n"); // Asking the user to make more purchase
			do { // Handling the out of bound range for the 1 and 2 menu
				System.out.println("Press [1] for yes [2] for no");
				y_n_answer = input.nextInt();
			} while (y_n_answer < 1 || y_n_answer > 2);
			
			if (y_n_answer == 2){
				goAgain = false;
			}

		}

	}
}
/*______________________________________________________________________________________________*/

/*--------- Sample Run --------------
 * Menu: 
P (process Purchase)
S (Shut down) 

p
You have 0 credit
How many yogurts would you like to buy ? 

9
Total number of stamps earned: 9
Transaction 1
Want to make another transaction?

Press [1] for yes [2] for no
1
You have 9 credit
Woudl you like to redeem your award? (Y/N) 

n
How many yogurts would you like to buy ? 

1
Total number of stamps earned: 10
Transaction 2
Want to make another transaction?

Press [1] for yes [2] for no
1
You have 10 credit
Woudl you like to redeem your award? (Y/N) 

n
How many yogurts would you like to buy ? 

2
Total number of stamps earned: 12
Transaction 3
Want to make another transaction?

Press [1] for yes [2] for no
1
You have 12 credit
Woudl you like to redeem your award? (Y/N) 

y
Total number of stamps earned: 5
Transaction 3
Want to make another transaction?

Press [1] for yes [2] for no
1
You have 5 credit
How many yogurts would you like to buy ? 

2
Total number of stamps earned: 7
Transaction 4
Want to make another transaction?

Press [1] for yes [2] for no
1
You have 7 credit
Woudl you like to redeem your award? (Y/N) 

s
****** Invalid Choice of Character *******
Press either lowercase/uppercase Y or N only 

y
Total number of stamps earned: 0
Transaction 4
Want to make another transaction?

Press [1] for yes [2] for no
4
Press [1] for yes [2] for no
1
You have 0 credit
How many yogurts would you like to buy ? 

-10
How many yogurts would you like to buy ? 

-20
How many yogurts would you like to buy ? 

2
Total number of stamps earned: 2
Transaction 5
Want to make another transaction?

Press [1] for yes [2] for no
1
You have 2 credit
How many yogurts would you like to buy ? 

9
Total number of stamps earned: 11
Transaction 6
Want to make another transaction?

Press [1] for yes [2] for no
1
You have 11 credit
Woudl you like to redeem your award? (Y/N) 

y
Total number of stamps earned: 4
Transaction 6
Want to make another transaction?

Press [1] for yes [2] for no
1
You have 4 credit
How many yogurts would you like to buy ? 

9
Total number of stamps earned: 13
Transaction 7
Want to make another transaction?

Press [1] for yes [2] for no
---------------- Sample Run to Show String Works --------------
Menu: 
P (process Purchase)
S (Shut down) 

process Purchase
You have 0 credit
How many yogurts would you like to buy ? 

9
Total number of stamps earned: 9
Transaction 1
Want to make another transaction?

Press [1] for yes [2] for no
2
*/
