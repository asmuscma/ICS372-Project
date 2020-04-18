import java.io.Serializable;

public class Furnace extends Appliance implements Serializable, Matchable<String> {
	private static final long serialVersionUID = 1L;
	private double heatingCapacity;

	/**
	 * @param manufacturer
	 * @param model
	 * @param applianceID
	 * @param price
	 * @param heatingCapacity
	 */
	public Furnace(String manufacturer, String model, String applianceID, double price, double heatingCapacity) {
		super(manufacturer, model, applianceID, price);
		this.heatingCapacity = heatingCapacity;
	}

	/**
	 * @return heating capacity of the furnace
	 */
	public double getHeatingCapacity() {
		return heatingCapacity;
	}

	public void accept(ApplianceVisitor visitor) {
		visitor.visit(this);
	}
}