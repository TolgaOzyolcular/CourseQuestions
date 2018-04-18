
/**
 *Bank class stores 1000 accounts in array and deals with data
 *@author saidzaripov
 *@version Neon.2 Release 
 *@see java.util.Scanner,java.io.*, java.util.ArrayList
 *@since 4.6.2
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Bank {
	private ArrayList<Object> bankData;
	/**
	 * private int numAccounts - holds the number of accounts private in
	 * sizeBank - holds capacity of the bank with bank accounts data.
	 */

	static int numAccounts;
	private int sizeBank;
	BankAccount bAcc = new BankAccount();
	BankAccount temp = null;

	/**
	 * Default constructor
	 */

	public Bank() {
		sizeBank = 1000;
		numAccounts = 0;
		bankData = new ArrayList(sizeBank);
	}

	/**
	 * 
	 * @param size - to allocate array
	 */

	public Bank(int size) {
		sizeBank = size;
		numAccounts = 0;
		bankData = new ArrayList(sizeBank);
	}

	/**
	 * addAccount adds accounts
	 * 
	 * @return - returns false if array is full
	 */
	
	public boolean addAccount() {		
		Scanner keyboard = new Scanner(System.in);
		if (numAccounts >= sizeBank) {
			System.out.println("Cannot add account. Database is full");
			return false;
		}

		System.out.print("Enter account type (s for savings, c for checking): ");
		String choice = new String();
		choice = keyboard.next();
		choice = choice.toLowerCase();
		while (choice.charAt(0) != 'c' && choice.charAt(0) != 's') {
			System.out.println("Invalid entry. Please enter s for Savings or c for Chequing: ");
			choice = keyboard.next();
			choice = choice.toLowerCase();
		}
		if (choice.charAt(0) == 'c') {
			bankData.add(numAccounts, new ChequingAccount());
		} else {
			bankData.add(numAccounts, new SavingsAccount());
		}

		if (choice.charAt(0) == 'c') {
			if (((ChequingAccount) bankData.get(numAccounts)).addBankAccount()) {

				numAccounts++;
				return true;
			} else {
				System.out.println("Invalid data");
				return false;
			}

		} else {
			if (((SavingsAccount) bankData.get(numAccounts)).addBankAccount()) {

				numAccounts++;
				return true;
			} else {
				System.out.println("Invalid data");
				return false;
			}
		}

	}
	/**
	 * toString method finds accounts.
	 */
	public boolean readFile(File file) {
		Scanner input;
		try {
			input = new Scanner(file);
		
			if (numAccounts >= sizeBank) {
				System.out.println("Cannot add account. Database is full");
				return false;
			}
			
			while(input.hasNextLine()) {
				String choice = new String();
				choice = input.next();
				choice = choice.toLowerCase();
	
				if (choice.charAt(0) == 'c') {
					bankData.add(numAccounts, new ChequingAccount());
					
					if (((ChequingAccount) bankData.get(numAccounts)).readFile(input)) {		
						numAccounts++;
					} 
					
					else {
						System.out.println("Input Error! Please review uploaded file.");
						return false;
					}
				} 
				else if (choice.charAt(0) == 's'){
					bankData.add(numAccounts, new SavingsAccount());
					
					if (((SavingsAccount) bankData.get(numAccounts)).readFile(input)) {		
						numAccounts++;
					} 
					
					else {
						System.out.println("Input Error! Please review uploaded file.");
						return false;
					}
				}	
				
				else {
					Exception e;
					input.close();
					return false;
				}
				
				
			}
			
			//return true;
		} 
		
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * toString method finds accounts.
	 */
	public String toString() {
		int accountIndex = toFind();
		if (accountIndex == -1)
			return "Account Number cannot be found in database";
		else
			return bankData.get(accountIndex).toString();
	}

	/**
	 * updateAccount method updates accounts
	 * 
	 * @return if the input did not match data
	 */
	public String updateAccount() {
		int accountIndex = toFind();
		if (accountIndex == -1)
			return "Account Number cannot be found ";

		Scanner keyboard = new Scanner(System.in);

		boolean dataOk = false;
		double updateAmount = 0;

		// read valid updateAmount from user
		while (!dataOk) {
			System.out.print("Enter amount to update (negative for withdrawal, positive for deposit): ");
			if (keyboard.hasNextDouble()) {
				updateAmount = keyboard.nextDouble();
				if (updateAmount < 0 && ((BankAccount) bankData.get(accountIndex)).isGreater(updateAmount))
					dataOk = true;
				if (updateAmount > 0)
					dataOk = true;
			} else {
				System.out.println("Invalid data. Reenter");
				String badData = new String();
				badData = keyboard.next();
			}
		}

		((BankAccount) bankData.get(accountIndex)).updateBalance(updateAmount);
		return "Account updated";

	}

	/**
	 * toFind method reads data 
	 * 
	 * @return returns account
	 */
	public int toFind() {
		Scanner keyboard = new Scanner(System.in);
		boolean dataOk = false;
		int accountToFind = 0;

		// read valid accountNumber from the user
		while (!dataOk) {
			System.out.print("Enter account number: ");
			if (keyboard.hasNextInt()) {
				accountToFind = keyboard.nextInt();
				if (accountToFind < 100000000)
					dataOk = true;
			} else {
				System.out.println("Invalid account number. Must be 3 digits or less");
				String badData = new String();
				badData = keyboard.next();
			}
		}

		for (int i = 0; i < numAccounts; i++)
			if (((BankAccount) bankData.get(i)).isEqual(accountToFind)) {
				return i;
			}

		/**
		 * @return - not found
		 */
		return -1;

	}

	/**
	 * monthUpdate method run the update of all accounts
	 */
	public void monthlyUpdate() {
		for (int i = 0; i < numAccounts; i++)
			((BankAccount) bankData.get(i)).monthlyUpdate();
	}

	/**
	 * printAccountDetails method prints all accounts
	 */

	public void printAccountDetails() {
		for (Object data : bankData) {
			System.out.println(data);
		}
	}

}
