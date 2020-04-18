import java.io.Serializable;

public class Furnace extends Appliance implements Serializable, Matchable<String> {
	private static final long serialVersionUID = 1L;
	private double heatingCapacity;

	public Furnace(String manufacturer, String model, String applianceID, double price, double heatingCapacity) {
		super(manufacturer, model, applianceID, price);
		this.heatingCapacity = heatingCapacity;
	}

	public double getHeatingCapacity() {
		return heatingCapacity;
	}

	@Override
	public boolean matches(String key) {
		// TODO Auto-generated method stub
		return false;
	}
}