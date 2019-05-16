import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		// Initializing variables
		Scanner sc = new Scanner(System.in);
		ReadFile rf = new ReadFile();
		WrilteLog logger = new WrilteLog();
		rf.load();
		String s = null;

		// Variables to intialize Employee
		String id = null;
		String name = null;
		String address = null;
		String accountNumber = null;
		String type = null;
		String balance = null;
		String uid = null;
		String uname = null;

		// Arrays of Employee instances
		ArrayList<Employee> employee = new ArrayList<Employee>();

		// Reading information from input.txt file
		while ((s = rf.readFile()) != null) {
			boolean goodInput = true;
			String[] information = getInformation(s);

			// Validate information about Employee
			goodInput = validateInformation(information, logger);
			if (goodInput) {

				// Creating instances of Employee
				id = information[0];
				name = information[1];
				address = information[2];
				accountNumber = information[3];
				type = information[4];
				balance = information[5];
				employee.add(new Employee(id, name, address, accountNumber, type, balance));
				logger.writer("successfully loaded employee information about " + name);
			}

		}

		// Show users options
		showUserOptions();

		// Getting user option
		String input = sc.next();
		while (true) {
			// Exit if input is '0'
			if (input.contains("0")) {
				logger.writer("user exited");
				break;
			}

			// Getting balance of employee
			else if (input.equals("1")) {
				System.out.println("insert ID");
				uid = sc.next();
				System.out.println("insert Name");
				uname = sc.next();
				uname = uname + " " + sc.next();
				logger.writer("Checking balance with id: " + uid + " and name: " + uname);
				checkBalance(uid, uname, employee, logger);

			} else {

				// Showing if user input invalid option
				System.out.println("invalid input...please try again!");
				logger.writer("User inserted invalid choice");
			}

			// Requesting user to try again
			System.out.println("insert '1' to try again or '0' to exit");

			input = sc.next();
		}
	}

	/*
	 * Validation Information from text If information doesnot contain 6 field
	 * return false If information type mismatch return false
	 */
	private static boolean validateInformation(String[] information, WrilteLog logger) {
		boolean result = true;
		if (information.length != 6) {
			logger.writer("Invalid input information");
			result = false;
		} else {

			try {
				int i = Integer.parseInt(information[0]);
			} catch (Exception e) {
				result = false;
				logger.writer("Employee ID invalid");
			}

			try {
				int name = Integer.parseInt(information[1]);
				logger.writer("Employees name invalid");
				result = false;
			} catch (Exception e) {

			}

			try {
				int address = Integer.parseInt(information[2]);
				logger.writer("Address was invalid");
				result = false;
			} catch (Exception e) {

			}

			try {
				int accountNumber = Integer.parseInt(information[3]);
			} catch (NumberFormatException e) {
				logger.writer("Account Number was invalid");
				result = false;
			}

			try {
				int type = Integer.parseInt(information[4]);
				logger.writer("Account type was invalid");
				result = false;
			} catch (Exception e) {

			}

			try {
				double balance = Double.parseDouble(information[5]);
			} catch (NumberFormatException e) {
				logger.writer("Balance input was invalid");
				result = false;
			}

		}
		return result;
	}

	// Returning balance of employee based on user input
	private static void checkBalance(String uid, String uname, ArrayList<Employee> employee, WrilteLog logger) {
		boolean found = false;
		for (int i = 0; i < employee.size(); i++) {
			if (employee.get(i).id.equals(uid) && employee.get(i).name.equals(uname)) {
				found = true;
				logger.writer("Information found and balanced showed ");
				System.out.println("Employee Balance is " + employee.get(i).balance);
				break;
			}
		}
		if (!found) {
			System.out.println("ID and name mismatch");
			logger.writer("Did not find information about " + uid + " and " + uname);
		}
	}

	private static void showUserOptions() {
		System.out.println("Welcome to our Banking System\n Insert '1' to check your balance \n or '0' to exit");

	}

	/*
	 * Getting information from file return String array from a String Line by
	 * splitting them based on ';' Then removing white spaces by trim method
	 */
	private static String[] getInformation(String s) {
		String[] temp;
		temp = s.split(";");
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[i].trim();

		}
		return temp;
	}
}
