
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

import java.io.Serializable;

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
	private Inventory inventory;
	private CustomerList customerList;
	private OrderList orderList;
	private static Company company;

	/**
	 * Private for the singleton pattern Creates the catalog and customer collection
	 * objects
	 */
	private Company() {
		inventory = Inventory.instance();
		customerList = CustomerList.instance();
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static Company instance() {
		if (company == null) {
			CustomerIdServer.instance(); // instantiate all singletons
			return (company = new Company());
		} else {
			return company;
		}
	}

	public Appliance addAppliance(String manufacturer, String model, double price) {
			Appliance item = .instance().createLoanableItem(
					manufacturer, model, price);
			if (inventory.insertLoanableItem(item)) {
				return (item);
			}
			return null;
		return null;
	}

	public Customer addCustomer(String name, String address, String phone) {
		Customer member = new Customer(name, address, phone);
		if (customerList.insertCustomer(member)) {
			return (member);
		}
		return null;
	}

	public Object searchMembership(String customerId) {
		return customerList.search(customerId);
	}

}
