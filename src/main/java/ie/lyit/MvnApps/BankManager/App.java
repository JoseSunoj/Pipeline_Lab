/**
 * 
 */
package ie.lyit.MvnApps.BankManager;

import java.util.Scanner;

/**
 * The executable class. The main method asked the customer to enter their
 * details. if the entries are valid a menu appears and the customer can do
 * their desired actions.
 * 
 * @author Sunoj Jose
 *
 */
public class App {
	private static CustomerAccountManager manager = new CustomerAccountManager();
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args commandline arguments
	 */
	public static void main(String[] args) {
		System.out.print("Please enter your name:");
		var name = scanner.nextLine().strip();
		System.out.println("Please enter your Account Number:");
		var acNumber = scanner.nextLine().strip();
		var customer = new Customer(name, acNumber);
		try {
			manager.addCustomer(name, acNumber);
			menu(customer);
		} catch (RuntimeException e) {
			System.out.println(e);
			App.main(null);
		}

	}

	/**
	 * Shows the menu options. The infinite while loop terminates only when the
	 * option e is selected.
	 * 
	 * @param customer the customer object
	 */
	protected static void menu(Customer customer) {
		var keepRunning = true;
		while (keepRunning) {
			System.out.println("*************************");
			System.out.println("Please choose an option: ");
			System.out.println("b-Balance");
			System.out.println("d-Deposit");
			System.out.println("e-Exist");
			System.out.println("w-Withdraw");
			System.out.println("*************************");
			var option = scanner.nextLine().strip();
			if (option.equalsIgnoreCase("b")) {
				System.out.println("Your Balance: " + manager.getBalanceInfo(customer));
			} else if (option.equalsIgnoreCase("d")) {
				System.out.print("Please enter the amount to deposit: ");
				var amount = (Double) Double.parseDouble(scanner.nextLine().strip());
				try {
					manager.deposit(customer, amount);
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if (option.equalsIgnoreCase("w")) {
				System.out.print("Please enter the amount to withdraw: ");
				var amount = (Double) Double.parseDouble(scanner.nextLine().strip());
				try {
					manager.withdraw(customer, amount);
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if (option.equalsIgnoreCase("e")) {
				keepRunning = false;
			} else {
				System.out.println("Please choose a valid option.");
			}
		}

	}

}
