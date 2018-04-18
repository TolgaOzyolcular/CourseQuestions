/**
 * SavingsgAccount extends BankAccount class. 
 * It will override calculateAndUpdateBalance method 
 * @author saidzaripov
 * @version Neon.2 Release 
 * @see String, java.util.Scanner;
 * @since 4.6.2
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class SavingsAccount extends BankAccount {
	private double minBalance;
	private double interestRate;

	
	/**
	 * addBankAccount method adds account into savings
	 * @return returns TRUE;
	 */
	public boolean addBankAccount() {
		super.addBankAccount();

		Scanner keyboard = new Scanner(System.in);
		boolean dataOk = false;

		// read valid monthly minimum balance from user
		while (!dataOk) {
			System.out.print("Enter minimum balance: ");
			if (keyboard.hasNextDouble()) {
				minBalance = keyboard.nextDouble();
				if (minBalance >= 0.00)
					dataOk = true;
			} else {
				System.out.println("Invalid minimum balance. Must be a positive number");
				String badData = new String();
				badData = keyboard.next();
			}
		}

		dataOk = false;
		// read valid monthly interest rate from user
		while (!dataOk) {
			System.out.print("Enter monthly interest rate(should be a number in(0,1)): ");
			if (keyboard.hasNextDouble()) {
				interestRate = keyboard.nextDouble();
				if (interestRate >= 0.00)
					dataOk = true;
			} else {
				System.out.println("Invalid monthly interest rate. Must be a positive number");
				String badData = new String();
				badData = keyboard.next();
			}
		}

		return true;
	}
	
	public boolean readFile(Scanner input) {		

		try{
			super.readFile(input);
			
			minBalance = input.nextDouble();
			interestRate = input.nextDouble();
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
	 * toString method shows overview of the balance with interest rate;
	 * @return returns data of balance
	 */
	public String toString() {
		return super.toString() + "  Minimum Balance: " + minBalance + "  Interest Rate: " + interestRate;
	}

	
	/**
	 * monthlyUpdate method updates accounts after interest rate was applied
	 */
	public void monthlyUpdate() {
		System.out.print("Adding interest of " + interestRate + "% to account " + accountNumber);
		if (minBalance > balance)
			System.out.println("......Insufficient funds for interest addition");
		else {
			balance += interestRate * balance;
			System.out.println(".  New balance is $ " + balance);
		}
	}

}