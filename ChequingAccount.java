/**
 * ChequingAccount class extends BankAccount class. 
 * It will override calculateAndUpdateBalance method 
 * @author saidzaripov
 * @version Neon.2 Release 
 * @see String, java.util.Scanner;
 * @since 4.6.2
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * fee var holds the value of fee;
 *
 */
public class ChequingAccount extends BankAccount {
	static double fee;

	
	/**
	 * addBankAccount method adds bank account
	 */
	public boolean addBankAccount() {
		super.addBankAccount();

		Scanner keyboard = new Scanner(System.in);
		boolean dataOk = false;

		// read valid monthly fee from user
		while (!dataOk) {
			System.out.print("Enter monthly fee: ");
			if (keyboard.hasNextDouble()) {
				fee = keyboard.nextDouble();
				if (fee >= 0.00)
					dataOk = true;
			} else {
				System.out.println("Invalid monthly fee.");
				String badData = new String();
				badData = keyboard.next();
			}
		}
		return true;
	}
	
	public boolean readFile(Scanner input) {

		try{
			super.readFile(input);
			
			fee = input.nextDouble();
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
	 * toString method prints fee line
	 * @return returns the value of fee
	 */
	public String toString() {
		return super.toString() + "  Fee: " + fee;
	}

	
	/**
	 * monthlyUpdate method prints and deducts fee
	 */
	
	public void monthlyUpdate() {
		System.out.print("Deducting fee of $" + fee + " from account " + accountNumber);
		if (fee > balance)
			System.out.println("Insufficient funds for fee withdrawal");
		else {
			balance -= fee;
			System.out.println(".  New balance is $ " + balance);
		}
	}

}
