/*
 * File Name: Assign1.java
 * Author: Said Zaripov, #040807972
 * Course: CST8132-OOP
 * Assignment: 1 (Lab 5)
 * Date: March 12,2018
 * Professor: Dr. Anu Thomas
 * Purpose: Create an object-oriented version of the software managing bank customers' bank accounts. The code should follow all OOPrinciples. 
 * Class List: Bank, Person, BankAccount, ChequingAccount, SavingsAccount;
 */
 
/**
 *Assign1 - this class will contain method main which will contain the menu.
 *@author saidzaripov
 * @version Neon.2 Release 
 * @see java.util.Scanner
 *@since 4.6.2
 */
import java.io.File;
import java.util.Scanner;

public class BankingApp {
	/**
	 * Creates a menu with choices that will lead to different classes and methods. 
	 * @param args main method
	 */

	public static void main(String[] args) {
		//BankAccount.readFile();
		
		Scanner keyboard = new Scanner(System.in);
		String choice = new String("a");
		char choiceFirstChar = choice.charAt(0);
		Bank bank = new Bank(1000);

		/**
		 * while loop: checks if the input from user wasn't 'q' and performs other options
		 */
		while (choiceFirstChar != 'q') {
			System.out
					.println("a: - Add new account;\n" + "u: - Update an account;\n" + "d: - Display an account;\n"
							+ "p: - Print all accounts;\n" + "m: - Run monthly update;\n" + "i: - Import data from file;\n"
							+ "q: - Quit\n"+ "Enter your option: \n" );

			choice = keyboard.next();

			choice = choice.toLowerCase();
			choiceFirstChar = choice.charAt(0);
			/**
			 * if and if-else loops to check if the input from user equals one of the options
			 */

			if (choiceFirstChar == 'a') {
				bank.addAccount();
			} else if (choiceFirstChar == 'd') {
				System.out.println(bank);
			} else if (choiceFirstChar == 'u') {
				System.out.println(bank.updateAccount());
			} else if (choiceFirstChar == 'm') {
				bank.monthlyUpdate();
			} else if (choiceFirstChar == 'i') {
				File file = new File("/Users/Tolga/Desktop/bankData.txt");
				bank.readFile(file);
			}else if (choiceFirstChar == 'p') {
				bank.printAccountDetails();
			} else if (choiceFirstChar == 'q') {
				System.out.println("quit");
			} else
				System.out.println("Invalid choice");
		}

	}

}
