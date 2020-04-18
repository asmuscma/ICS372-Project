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
import java.io.IOException;


/**
 * CustomerList
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public class CustomerList extends ItemList<Customer, String> {
	private static final long serialVersionUID = 1L;
	private static CustomerList customerList;

	/**
	 * Singleton
	 */
	private CustomerList() {
	}

	/**
	 * @return Singleton Object
	 */
	public static CustomerList instance() {
		if (customerList == null) {
			return (customerList = new CustomerList());
		} else {
			return customerList;
		}
	}

	/* (non-Javadoc)
	 * @see ItemList#search(java.lang.Object)
	 */
	@Override
	public Customer search(String CustomerId) {
		return super.search(CustomerId);
	}

	/**
	 * Insert Customer
	 * @param Customer
	 * @return true if customer inserted
	 */
	public boolean insertCustomer(Customer Customer) {
		return super.add(Customer);
	}

	/**
	 * Write
	 * @param output
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream output) throws IOException {
		output.defaultWriteObject();
		output.writeObject(customerList);
	}

	/**
	 * Read
	 * @param input
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream input) throws IOException, ClassNotFoundException {
		input.defaultReadObject();
		if (customerList == null) {
			customerList = (CustomerList) input.readObject();
		} else {
			input.readObject();
		}
	}
}