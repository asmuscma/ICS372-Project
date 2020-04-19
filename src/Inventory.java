
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
import java.io.Serializable;
import java.util.HashMap;

/**
 * The collection class for all Appliance objects
 * 
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Inventory inventory;
	private HashMap<String, Integer> hmap = new HashMap<String, Integer>();

	/**
	 * Private constructor for singleton pattern
	 */
	private Inventory() {
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static Inventory instance() {
		if (inventory == null) {
			return (inventory = new Inventory());
		} else {
			return inventory;
		}
	}

	/**
	 * Removes an appliance from the inventory.
	 * 
	 */
	public boolean removeAppliance(String applianceId, int purchaseQuantity) {
		int presentQuantity = hmap.get(applianceId);
		if (purchaseQuantity > presentQuantity) {
			return false;
		} else {
			hmap.replace(applianceId, presentQuantity - purchaseQuantity);
			return true;
		}
	}

	/**
	 * Adds an appliance into the inventory
	 * 
	 * @param appliance the appliance to be inserted
	 * @return true if the appliance could be inserted. Currently always true
	 */
	public boolean insertAppliance(String applianceId, int addQuantity) {
		int quantityOnHand = hmap.get(applianceId);
		hmap.replace(applianceId, quantityOnHand + addQuantity);
		return true;
	}

	/**
	 * Searches the inventory for the model specified and returns the count.
	 * 
	 * @param the model of the appliance to be searched
	 * @return the quantity of the item in stock
	 */
	public int searchInventory(String applianceId) {
		return hmap.get(applianceId);
	}

	/**
	 * Supports serialization
	 * 
	 * @param output the stream to be written to
	 */
	private void writeObject(java.io.ObjectOutputStream output) throws IOException {
		output.defaultWriteObject();
		output.writeObject(inventory);
	}

	/**
	 * Supports deserialization
	 * 
	 * @param input the stream to be read from
	 */
	private void readObject(java.io.ObjectInputStream input) throws IOException, ClassNotFoundException {
		input.defaultReadObject();
		if (inventory == null) {
			inventory = (Inventory) input.readObject();
		} else {
			input.readObject();
		}
	}
}
