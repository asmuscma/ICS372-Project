import java.io.Serializable;

/**
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public class WasherDryer extends Appliance implements Serializable, Matchable<String> {
	private static final long serialVersionUID = 1L;
	private double repairCost;

	/**
	 * @param manufacturer
	 * @param model
	 * @param applianceID
	 * @param price
	 * @param repairPlanCost
	 */
	public WasherDryer(String manufacturer, String model, double price, double repairCost) {
		super(manufacturer, model, price, repairCost);
	}

	/**
	 * @return repairPlanCost of the WasherDryer0
	 */
	public double getRepairCost() {
		return repairCost;
	}

}
