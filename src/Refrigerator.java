import java.io.Serializable;

/**
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public class Refrigerator extends Appliance implements Serializable, Matchable<String> {
	private static final long serialVersionUID = 1L;
	private String storageCapacity;

	/**
	 * @param manufacturer
	 * @param model
	 * @param applianceID
	 * @param price
	 * @param storageCapacity
	 */
	public Refrigerator(String manufacturer, String model, double price, String storageCapacity) {
		super(manufacturer, model, price, storageCapacity);
	}

	/**
	 * @return storage capacity of the refrigerator
	 */
	public String getStorageCapacity() {
		return storageCapacity + "L";
	}
}
