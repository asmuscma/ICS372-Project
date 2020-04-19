import java.io.Serializable;

/**
 * @author tarnd
 *
 */
public abstract class Appliance implements Matchable<String>, Serializable {

	private static final long serialVersionUID = 1L;
	private String manufacturer;
	private String model;
	private String applianceID;
	private double price;
	private static final String APPLIANCE_STRING = "A";

	/**
	 * @param manufacturer appliance manufacturer
	 * @param model        appliance model
	 * @param applianceID  appliance ID
	 * @param price        appliance price
	 */
	public Appliance(String manufacturer, String model, String applianceID, double price) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.price = price;
		applianceID = APPLIANCE_STRING + (ApplianceIdServer.instance()).getId();
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @return model name
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return ID number of the appliance
	 */
	public String getID() {
		return applianceID;
	}

	/**
	 * @return price of the appliance
	 */
	public double getPrice() {
		return price;
	}

	public boolean matches(String key) {
		return this.getID().equals(key);
	}

	/**
	 * toString method for appliances
	 */
	@Override
	public String toString() {
		return "Appliance [manufacturer=" + manufacturer + ", model=" + model + ", applianceID=" + applianceID
				+ ", price=" + price + "]";
	}

	public void accept(ApplianceVisitor visitor) {
		visitor.visit(this);
	}
}
