
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;

/**
 * This is an implementation of a Company that uses the facade pattern.
 * 
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int ITEM_NOT_FOUND = 1;
	public static final int ITEM_NOT_ISSUED = 2;
	public static final int ITEM_HAS_HOLD = 3;
	public static final int ITEM_ISSUED = 4;
	public static final int HOLD_PLACED = 5;
	public static final int NO_HOLD_FOUND = 6;
	public static final int OPERATION_COMPLETED = 7;
	public static final int OPERATION_FAILED = 8;
	public static final int NO_SUCH_CUSTOMER = 9;

	public static final int WASHERDRYER = 1;
	public static final int FURNACE = 2;
	public static final int REFRIGERATOR = 3;

	public static final int PURCHASE = 1;
	public static final int BACKORDER = 2;
	public static final int REPAIRPLAN = 3;
	private Inventory inventory;
	private CustomerList customerList;
	private ApplianceList applianceList;
	private OrderList orderList;
	private static Company company;

	/**
	 * Private for the singleton pattern Creates the inventory and customer
	 * collection objects
	 */
	private Company() {
		inventory = Inventory.instance();
		customerList = CustomerList.instance();
		applianceList = ApplianceList.instance();
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static Company instance() {
		if (company == null) {
			CustomerIdServer.instance(); // instantiate all singletons
			OrderIdServer.instance();
			ApplianceIdServer.instance();
			return (company = new Company());
		} else {
			return company;
		}
	}

	public Customer addCustomer(String name, String phone) {
		Customer customer = new Customer(name, phone);
		if (customerList.insertCustomer(customer)) {
			return (customer);
		}
		return null;
	}

	public Appliance addModel(int type, String manufacturer, String model, double price, double proprietary) {
		Appliance item = ApplianceFactory.instance().createAppliance(type, manufacturer, model, price, proprietary);
		if (applianceList.insertAppliance(item)) {
			return (item);
		}
		return null;
	}

	public Order addOrder(int type, String customerId, String applianceId, int quantity, Calendar date) {
		applianceList.search(applianceId)
		Order item = OrderFactory.instance().createOrder(type, customerId, applianceId, orderCost, quantity, date);
	}

	public String searchModel(String applianceId) {
		return applianceList.search(applianceId).getModel();
	}

	public Appliance searchApplianceList(String applianceId) {
		return applianceList.search(applianceId);
	}

	public boolean addToInventory(String applianceId, int quantity) {
		return inventory.addToInventory(applianceId, quantity);
	}

	public int searchInventory(String applianceId) {
		return inventory.searchInventory(applianceId);
	}

	public Customer searchCustomer(String customerId) {
		return customerList.search(customerId);
	}

	public Order searchBackorder(String orderId) {
		return orderList.search(orderId);
	}

	/**
	 * Retrieves a deserialized version of the library from disk
	 * 
	 * @return a Library object
	 */
	public static Company retrieve() {
		try {
			FileInputStream file = new FileInputStream("CompanyData");
			ObjectInputStream input = new ObjectInputStream(file);
			input.readObject();
			CustomerIdServer.retrieve(input);
			return company;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
	}

	/**
	 * Serializes the Library object
	 * 
	 * @return true iff the data could be saved
	 */
	public static boolean save() {
		ObjectOutputStream output = null;
		try {
			FileOutputStream file = new FileOutputStream("CompanyData");
			output = new ObjectOutputStream(file);
			output.writeObject(company);
			output.writeObject(CustomerIdServer.instance());
			output.close();
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}

	/**
	 * Writes the object to the output stream
	 * 
	 * @param output the stream to be written to
	 */
	private void writeObject(java.io.ObjectOutputStream output) throws IOException {
		output.defaultWriteObject();
		output.writeObject(company);
	}

	/**
	 * Reads the object from a given stream
	 * 
	 * @param input the stream to be read
	 */
	private void readObject(java.io.ObjectInputStream input) throws IOException, ClassNotFoundException {
		input.defaultReadObject();
		if (company == null) {
			company = (Company) input.readObject();
		} else {
			input.readObject();
		}
	}

	/**
	 * String form of the library
	 * 
	 */
	@Override
	public String toString() {
		return inventory + "\n" + customerList;
	}

	public String getRevenue() {// Basic idea don't know if it is correct. I fail at using iterator
		String test;
		double id = 0;
		for (Iterator<Order> iterator = orderList.iterator(); iterator.hasNext();) {
			Order order = iterator.next();
			id = +order.getOrderCost();

			iterator.remove();

		}
		return test = Double.toString(id);
	}

}
