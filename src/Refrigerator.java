import java.io.Serializable;

public class Refrigerator extends Appliance implements Serializable, Matchable<String> {
	private static final long serialVersionUID = 1L;
	private double storageCapacity;

	public Refrigerator(String manufacturer, String model, String applianceID, double price, double storageCapacity) {
		super(manufacturer, model, applianceID, price);
		this.storageCapacity = storageCapacity;
	}

	public double getStorageCapacity() {
		return storageCapacity;
	}

	@Override
	public boolean matches(String key) {
		// TODO Auto-generated method stub
		return this.getID().equals(key);
	}

}
