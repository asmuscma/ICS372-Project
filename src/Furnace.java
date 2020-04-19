import java.io.Serializable;

public class Furnace extends Appliance implements Serializable, Matchable<String> {
	private static final long serialVersionUID = 1L;
	private String heatingCapacity;

	/**
	 * @param manufacturer
	 * @param model
	 * @param applianceID
	 * @param price
	 * @param heatingCapacity
	 */
	public Furnace(String manufacturer, String model, double price, String heatingCapacity) {
		super(manufacturer, model, price, heatingCapacity);
	}

	/**
	 * @return heating capacity of the furnace
	 */
	public String getHeatingCapacity() {
		return heatingCapacity + "BTU";
	}

	@Override
	public void accept(ApplianceVisitor visitor) {
		visitor.visit(this);
	}
}