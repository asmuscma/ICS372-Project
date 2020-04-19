
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
 * This class implements the customer
 * 
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 * 
 */
public class Customer implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String customerID;
	private static final String MEMBER_STRING = "M";

	/**
	 * Single Customer
	 * 
	 * @param name
	 * @param phone
	 * @param id
	 */
	public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
		customerID = MEMBER_STRING + (CustomerIdServer.instance()).getId();
	}

	/**
	 * Getter for name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for phone
	 * 
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter for phone
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Getter for customerID
	 * 
	 * @return customerID
	 */
	public String getID() {
		return customerID;
	}

	/**
	 * Matchable interface
	 * 
	 * @param key customer ID
	 */
	public boolean matches(String key) {
		return this.getID().equals(key);
	}

}