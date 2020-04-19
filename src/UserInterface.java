
/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * This class implements the user interface for the Company project. The
 * commands are encoded as integers using a number of static final variables. A
 * number of utility methods exist to make it easier to parse the input.
 * 
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 * 
 *         TODO addItem, addOrder, enroll in a repair plan, withdraw from a
 *         repair plan, change repair plans, print revenue, list appliances,
 *         list users in repair plans, list customers, list backorders
 * 
 */
public class UserInterface {
	private static UserInterface userInterface;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Company company;
	private static final int EXIT = 0;
	private static final int ADD_CUSTOMER = 1;
	private static final int ADD_APPLIANCE = 2;
	private static final int ADD_ORDER = 3;
	private static final int ADD_BACKORDER = 4;
	private static final int ADD_REPAIRPLAN = 5;
	private static final int ADD_ITEM = 6;
	private static final int GET_ORDERS = 7;
	private static final int PROCESS_BACKORDERS = 8;
	private static final int PROCESS_REPAIRPLANS = 9;
	private static final int GET_REVENUE = 10;
	private static final int SAVE = 11;
	private static final int RETRIEVE = 12;
	private static final int PRINT_FORMATTED = 13;
	private static final int HELP = 14;

	/**
	 * Private constructor to implement the singleton pattern. It looks for any
	 * saved data, otherwise it will get a singleton Company object.
	 */
	private UserInterface() {
		if (yesOrNo("Look for saved data and use it?")) {
			retrieve();
		} else {
			company = Company.instance();
		}
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static UserInterface instance() {
		if (userInterface == null) {
			return userInterface = new UserInterface();
		} else {
			return userInterface;
		}
	}

	/**
	 * Gets a token after prompting
	 * 
	 * @param prompt - whatever the user wants as prompt
	 * @return - the token from the keyboard
	 * 
	 */
	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}

	/**
	 * Queries for a yes or no and returns true for yes and false for no
	 * 
	 * @param prompt The string to be prepended to the yes/no prompt
	 * @return true for yes and false for no
	 * 
	 */
	private boolean yesOrNo(String prompt) {
		String more = getToken(prompt + " (Y|y)[es] or anything else for no");
		if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
			return false;
		}
		return true;
	}

	/**
	 * Converts the string to a number
	 * 
	 * @param prompt the string for prompting
	 * @return the integer corresponding to the string
	 * 
	 */
	public int getNumber(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Integer number = Integer.valueOf(item);
				return number.intValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}

	/**
	 * Prompts for a date and gets a date object
	 * 
	 * @param prompt the prompt
	 * @return the data as a Calendar object
	 */
	public Calendar getDate(String prompt) {
		do {
			try {
				Calendar date = new GregorianCalendar();
				String item = getToken(prompt);
				DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
				date.setTime(dateFormat.parse(item));
				return date;
			} catch (Exception fe) {
				System.out.println("Please input a date as mm/dd/yy");
			}
		} while (true);
	}

	/**
	 * Prompts for a command from the keyboard
	 * 
	 * @return a valid command
	 * 
	 */
	public int getCommand() {
		do {
			try {
				int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
				if (value >= EXIT && value <= HELP) {
					return value;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Enter a number");
			}
		} while (true);
	}

	/**
	 * Displays the help screen
	 * 
	 */
	public void help() {
		System.out.println("Enter a number between 0 and 12 as explained below:");
		System.out.println(EXIT + " to Exit\n");
		System.out.println(ADD_CUSTOMER + " to add a customer");
		System.out.println(ADD_APPLIANCE + " to add appliances");
		System.out.println(ADD_ORDER + " to add a transaction/order");
		System.out.println(ADD_BACKORDER + " to place a backorder");
		System.out.println(ADD_REPAIRPLAN + " to add a repair plan");
		System.out.println(ADD_ITEM + " to add items to the inventory");
		System.out.println(GET_ORDERS + " to print the list of transactions");
		System.out.println(PROCESS_BACKORDERS + " to process any backorders");
		System.out.println(PROCESS_REPAIRPLANS + " to any repair plans");
		System.out.println(GET_REVENUE + " to print total revenue");
		System.out.println(SAVE + " to  save data");
		System.out.println(RETRIEVE + " to  retrieve");
		System.out.println(PRINT_FORMATTED + " to  print items formatted");
		System.out.println(HELP + " for help");
	}

	/**
	 * Method to be called for adding a customer. Prompts the user for the
	 * appropriate values and uses the appropriate Company method for adding the
	 * customer.
	 * 
	 */
	public void addCustomer() {
		String name = getToken("Enter member name");
		String phone = getToken("Enter phone");
		Customer result;
		result = company.addCustomer(name, phone);
		if (result == null) {
			System.out.println("Could not add member");
		}
		System.out.println(result);
	}

	/**
	 * This method is to be called when you need to add an appliance. It will prompt
	 * the user for the manufacturer, model, and price. Uses the company method to
	 * add it to the appliance list.
	 */
	public void addAppliance() {
		int type = Integer.parseInt(
				getToken("Please enter the appliance type (1 = Washer/Dryer, 2 = Furnace, 3 = Refrigerator)"));
		String manufacturer = getToken("Please enter the manufacturer id");
		String model = getToken("Please enter the model");
		double price = Double.parseDouble(getToken("Please enter the price"));
		double proprietary = Double.parseDouble(
				getToken("Please enter the proprietary info (Repair cost, heat capacity, storage capacity)"));
		Appliance result;
		result = company.addModel(type, manufacturer, model, price, proprietary);
		if (result == null) {
			System.out.println("Could not add appliance.");
		}
		System.out.println(result);
	}

	/**
	 * This method is to be called when you need to place an order on an appliance.
	 * It will prompt the user for a customerId and check if it is valid before
	 * asking for the applianceId and quantity. It uses the Company method to add it
	 * to the order list.
	 * 
	 */
	public void addOrder() {
		Appliance result;
		String customerId = getToken("Please enter the customer id");
		if (company.searchCustomer(customerId) == null) {
			System.out.println("No such customer");
			return;
		}
		do {
			String applianceId = getToken("Please enter the appliance ID");
			if (company.searchBackorder(applianceId) == null) {
				double quantity = Double.parseDouble(getToken("Please enter the quantity"));
				if (company.searchInventory(applianceId) >= quantity) {
					result = company.addOrder(customerId, applianceId);
					if (result != null) {
						System.out.println(result.getManufacturer() + "  " + result.getModel() + "   "
								+ result.getPrice() + "  " + quantity);
					} else {
						System.out.println("Appliance could not be sold");
					}
					if (!yesOrNo("Add more orders?")) {
						break;
					}
				} else {
					System.out.println("Not enough in stock");
				}
			} else {
				System.out.println("Appliance is on backorder");
			}
		} while (true);
	}

	/**
	 * This method is to be called when you need to place a backorder on an
	 * appliance. It will prompt the user for a customerId and check if it is valid
	 * before asking for the applianceId and quantity. It uses the Company method to
	 * add it to the order list.
	 * 
	 * 
	 */
	public void addBackorder() {
		Appliance result;
		String customerId = getToken("Please enter the customer id");
		if (company.searchCustomer(customerId) == null) {
			System.out.println("No such customer");
			return;
		}
		do {
			String applianceId = getToken("Please enter the model id");
			if (company.searchModel(applianceId) != null) {
				double quantity = Double.parseDouble(getToken("Please enter the quantity"));
				if (company.searchInventory(applianceId) <= quantity) {
					result = company.addBackorder(customerId, applianceId);
					if (result != null) {
						System.out.println(result.getManufacturer() + "  " + result.getModel() + "   "
								+ result.getPrice() + "  " + quantity);
					} else {
						System.out.println("Appliance could not be backordered");
					}
					if (!yesOrNo("Add more backorders?")) {
						break;
					}
				} else {
					System.out.println("Enough is in stock to order");
				}
			} else {
				System.out.println("Appliance is already in stock");
			}
		} while (true);
	}

	/**
	 * TODO Implement this
	 */
	public void addRepairPlan() {

	}

	/**
	 * This method is to be used when the user needs to add an item to the
	 * inventory. It will prompt the user for an applianceId and a quantity. Uses
	 * the Company method to add items.
	 */
	public void addToInventory() {
		String applianceId = getToken("Please enter the appliance id");
		int quantity = Integer.parseInt(getToken("Please enter the quantity"));
		company.addToInventory(applianceId, quantity); // I know Im suppose to change this but Im a bit confuse on what
														// ya
														// wanted
		System.out.println("Added " + quantity + " of " + applianceId + " to inventory");
	}

	/**
	 * TODO Implement this
	 */
	public void getOrders() {
	}

	/**
	 * Method to be called for processing backorders. Prompts the user for the
	 * appropriate values and uses the Company method to process any backorders.
	 */
	public void processBackorders() {
		Customer result;
		do {
			String applianceId = getToken("Please enter the applianceId");
			result = company.processBackorder(applianceId);
			if (result != null) {
				System.out.println(result);
			} else {
				System.out.println("No valid backorders left");
			}
			if (!yesOrNo("Process more backorders?")) {
				break;
			}
		} while (true);
	}

	/**
	 * Method to be called for processing repair plans. Prompts the user for the
	 * appropriate values and uses the Company method to process any repair plans.
	 */
	public void processRepairPlans() {
		Customer result;
		do {
			String repairPlanId = getToken("Please enter the repairPlanId");
			result = company.processRepairPlan(repairPlanId);
			if (result != null) {
				System.out.println(result);
			} else {
				System.out.println("No valid repair plans left");
			}
			if (!yesOrNo("Process more repair plans?")) {
				break;
			}
		} while (true);
	}

	/**
	 * Method to be called for printing the total amount of revenue. Uses the
	 * Company method to iterate through every order and add up the total money.
	 */
	public void getRevenue() {
		System.out.println("Total revenue: $" + company.getRevenue());
	}

	/**
	 * Method to be called for saving the Company object. Uses the appropriate
	 * Company method for saving.
	 * 
	 */
	private void save() {
		if (Company.save()) {
			System.out.println(" The library has been successfully saved in the file LibraryData \n");
		} else {
			System.out.println(" There has been an error in saving \n");
		}
	}

	/**
	 * Method to be called for retrieving saved data. Uses the appropriate Library
	 * method for retrieval.
	 * 
	 */
	private void retrieve() {
		try {
			Company tempLibrary = Company.retrieve();
			if (tempLibrary != null) {
				System.out.println("The library has been successfully retrieved from the file LibraryData \n");
				company = tempLibrary;
			} else {
				System.out.println("File doesnt exist; creating new library");
				company = Company.instance();
			}
		} catch (Exception cnfe) {
			cnfe.printStackTrace();
		}
	}

	/**
	 * 
	 * Prints the items in a unique format for each type of item.
	 */
	public void printFormatted() {
		company.processAppliances(PrintFormat.instance());
	}

	/**
	 * This method is used as a facility for automated testing. This should add 5+
	 * customers, 20+ appliances and test business processes 1 through 6
	 */
	public void generateTestBed() {
		/*
		 * Business Process 2 -- Add customer
		 */
		company.addCustomer("John Smith", "123-456-7890");
		company.addCustomer("Jane Adams", "987-654-3210");
		company.addCustomer("Fred Morris", "111-222-3333");
		company.addCustomer("Katherine Payne", "444-555-6666");
		company.addCustomer("Tim Rodgers", "246-810-1214");

		/*
		 * Business process 1 -- Add appliance
		 */
		company.addModel(1, "Good Company", "Best Washer", 1000, 250);
		company.addModel(1, "Bad Company", "Worst Washer", 500, 400);
		company.addModel(1, "Okay Company", "Decent Washer", 750, 450);
		company.addModel(1, "Good Company", "Best Dryer", 1200, 300);
		company.addModel(1, "Bad Company", "Worst Dryer", 500, 350);
		company.addModel(1, "Okay Company", "Economy Dryer", 700, 400);
		company.addModel(2, "Kilauea Heating", "Super-Heater", 2500, 1000000);
		company.addModel(2, "Kilauea Heating", "Magma-Heater", 3000, 800000);
		company.addModel(2, "Arizona Thermal", "Heater 1", 2600, 720000);
		company.addModel(2, "Arizona Thermal", "Heater 2", 3200, 900000);
		company.addModel(2, "Good Company", "Best Heater", 5000, 1500000);
		company.addModel(2, "Bad Company", "Worst Portable Heater", 100, 5000);
		company.addModel(2, "Okay Company", "Decent Portable Heater", 120, 8000);
		company.addModel(3, "Emperor", "Penguin Mini-Fridge", 150, 2.6);
		company.addModel(3, "Emperor", "Penguin Fridge", 250, 4.5);
		company.addModel(3, "Emperor", "Penguin Mega-Fridge", 350, 8.6);
		company.addModel(3, "Rockhopper", "Polar Mini-Fridge", 120, 2.5);
		company.addModel(3, "Rockhopper", "Polar Fridge", 140, 8.3);
		company.addModel(3, "Rockhopper", "Polar Mega-Fridge", 310, 8.1);
		company.addModel(3, "Minnesota Dynamic", "Duluth", 1000, 20.3);

		/*
		 * Business Process 3 -- Add to inventory and fulfill backorders
		 */
		company.addToInventory("001", (int) (Math.random() * 10));
		company.addToInventory("002", (int) (Math.random() * 10));
		company.addToInventory("003", (int) (Math.random() * 10));
		company.addToInventory("004", (int) (Math.random() * 10));
		company.addToInventory("005", (int) (Math.random() * 10));
		company.addToInventory("006", (int) (Math.random() * 10));
		company.addToInventory("007", (int) (Math.random() * 10));
		company.addToInventory("008", (int) (Math.random() * 10));
		company.addToInventory("009", (int) (Math.random() * 10));
		company.addToInventory("010", (int) (Math.random() * 10));
		company.addToInventory("011", (int) (Math.random() * 10));

		/*
		 * Business Process 4 -- Purchase
		 */

		company.addOrder("M1", "A1", (int) (Math.random() * 10));
		company.addOrder("M2", "A1", (int) (Math.random() * 10));
		company.addOrder("M2", "A2", (int) (Math.random() * 10));
		company.addOrder("M3", "A3", (int) (Math.random() * 10));
		company.addOrder("M4", "A11", (int) (Math.random() * 10));
		company.addOrder("M5", "A17", (int) (Math.random() * 10));

		/*
		 * Business Process 5 -- Enroll in repair plan
		 */
		company.addRepairPlan("M1", "A1");
		company.addRepairPlan("M2", "A1");
		company.addRepairPlan("M3", "A3");

		/*
		 * Business Process 6 -- Withdraw from repair plan
		 */

		/*
		 * Business Process 7 -- Change repair plans
		 */

		/*
		 * Business Process 8 -- Print revenue
		 */
		printRevenue();

		/*
		 * Business Process 9 -- List appliances
		 */

		/*
		 * Business Process 10 -- List users in repair plans
		 */

		/*
		 * Business Process 11 -- List customers
		 */

		/*
		 * Business Process 12 -- List backorders
		 */

		/*
		 * Business Process 13 -- Save data to disk
		 */
		save();
	}

	/**
	 * Orchestrates the whole process. Calls the appropriate method for the
	 * different functionalities.
	 * 
	 */
	public void process() {
		if (yesOrNo("Would you like to generate a test bed?")) {
			generateTestBed();
		}
		int command;
		help();
		while ((command = getCommand()) != EXIT) {
			switch (command) {
			case ADD_CUSTOMER:
				addCustomer();
				break;
			case ADD_APPLIANCE:
				addAppliance();
				break;
			case ADD_ORDER:
				addOrder();
				break;
			case ADD_BACKORDER:
				addBackorder();
				break;
			case ADD_REPAIRPLAN:
				addRepairPlan();
				break;
			case ADD_ITEM:
				addToInventory();
				break;
			case GET_ORDERS:
				getOrders();
				break;
			case PROCESS_BACKORDERS:
				processBackorders();
				break;
			case PROCESS_REPAIRPLANS:
				processRepairPlans();
				break;
			case GET_REVENUE:
				getRevenue();
				break;
			case SAVE:
				save();
				break;
			case RETRIEVE:
				retrieve();
				break;
			case PRINT_FORMATTED:
				printFormatted();
				break;
			case HELP:
				help();
				break;
			}
		}
	}

	/**
	 * The method to start the application. Simply calls process().
	 * 
	 * @param args not used
	 */
	public static void main(int[] args) {
		UserInterface.instance().process();
	}
}
