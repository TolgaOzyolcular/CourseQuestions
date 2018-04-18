
/**
 * BankAccount class adds accounts and updates them
 * @author saidzaripov
 * @version Neon.2 Release 
 * @see java.util.Scanner, 
 * @since 4.6.2
 * 
 */
import java.io.File;
import java.util.*;
import java.util.Scanner;

public class BankAccount {
	/**
	 * accountNumber var holds the number of the account 
	 * balance var holds balance of the account 
	 * phoneNumber var holds phone number of the account holder
	 * the String emailAddress holds the email address of the holder
	 * 
	 */
	protected int accountNumber;
	protected String firstName = new String();
	protected String lastName = new String();
	protected double balance;
	protected long phoneNumber;
	protected String emailAddress = new String();

	/**
	 * toString method prints out all info of the account
	 * 
	 * @return returns the value of print
	 */
	public String toString() {
		String print = "AccountNumber: " + accountNumber + "  " + firstName + " " + lastName + " Phone Number: "
				+ phoneNumber + " " + " Email Address:" + emailAddress + " " + " Balance : " + balance;
		return print;
	}

	/**
	 * addBankAccount method takes info from user
	 * 
	 * @return returns value TRUE
	 */
	public boolean addBankAccount() {
		Scanner keyboard = new Scanner(System.in);
		boolean dataOk = false;

		// read valid accountNumber from user
		while (!dataOk) {
			System.out.print("Enter account number: ");
			if (keyboard.hasNextInt()) {
				accountNumber = keyboard.nextInt();

				dataOk = true;
			} else {
				System.out.println("Invalid account number. Must be 3 digits or less");
				String badData = new String();
				badData = keyboard.next();
			}
		}

		System.out.print("Enter first name of account holder : ");
		firstName = keyboard.next();

		System.out.print("Enter last name of account holder : ");
		lastName = keyboard.next();

		System.out.println("Enter phone Number : ");
		Scanner p = new Scanner(System.in);
		phoneNumber = p.nextLong();

		System.out.println("Enter Email address : ");
		Scanner e = new Scanner(System.in);
		emailAddress = e.next();

		// read valid balance
		dataOk = false;
		while (!dataOk) {
			System.out.print("Enter balance: ");
			if (keyboard.hasNextDouble()) {
				balance = keyboard.nextDouble();
				if (balance >= 0.00)
					dataOk = true;
			} else {
				System.out.println("Invalid balance...must be a positive number");
				String badData = new String();
				badData = keyboard.next();
			}
		}

		return true;
	}
	
	/**
	 * readFile method checks the contents of a file
	 * 
	 * @param Scanner
	 * @return boolean
	 */
	
	public boolean readFile(Scanner input) {
		try {
			accountNumber = input.nextInt();
			firstName = input.next();
			lastName = input.next();
			phoneNumber = input.nextLong();
			emailAddress = input.next();
			balance = input.nextDouble();
			
			return true;
		}
		catch(InputMismatchException e) {
			return false;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * isEqual method checks the number of account
	 * 
	 * @param accountToFind
	 * @return returns account
	 */
	public boolean isEqual(int accountToFind) {
		return accountNumber == accountToFind;
	}

	/**
	 * isGreater method
	 * 
	 * @param amount
	 * @return returns true or false value
	 */
	public boolean isGreater(double amount) {
		return balance + amount >= 0.0;
	}

	/**
	 * updateBalance method updates
	 * 
	 * @param amount
	 */
	public void updateBalance(double amount) {
		balance += amount;
	}

	/**
	 * monthlyUpdate
	 */
	public void monthlyUpdate() {
	}

}
