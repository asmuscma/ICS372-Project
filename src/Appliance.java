import java.io.Serializable;

public abstract class Appliance implements Matchable<String>, Serializable {

	private static final long serialVersionUID = 1L;
	private String manufacturer;
	private String model;
	private String applianceID;
	private double price;

	public Appliance(String manufacturer, String model, String applianceID, double price) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.applianceID = applianceID;
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	public String getID() {
		return applianceID;
	}

	public double getPrice() {
		return price;
	}
}
