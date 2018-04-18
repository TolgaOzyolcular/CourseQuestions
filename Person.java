/**
 * Person class holds the info of the account holder
 * @author saidzaripov
 * @version Neon.2 Release 
 * @see String;
 * @since 4.6.2
 */
public class Person {
	/**
	 * firstName holds first name
	 * lastName holds last name
	 * phoneNumber holds cell number
	 * emailAddress holds email address
	 */
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String emailAddress;

	public Person() {

	}

	/**
	 * 
	 * @param fName firstName
	 * @param lName lastName
	 * @param ph phoneNumber
	 * @param email emailAddress
	 */
	public Person(String fName, String lName, long ph, String email) {
		firstName = fName;
		lastName = lName;
		emailAddress = email;
		phoneNumber = ph;
	}

	/**
	 * getName method shows first and last name (getter method)
	 * @return returns first and last name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}

	/**
	 * getPhoneNumber getter method
	 * @return returns phoneNumber
	 */
	public long getPhoneNumber() {

		return phoneNumber;
	}

	/**
	 * emailAddress getter method
	 * @return returns emailAddress
	 */
	public String emailAddress() {
		return emailAddress;
	}

}
