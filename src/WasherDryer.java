import java.io.Serializable;

/**
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public class WasherDryer extends Appliance implements Serializable, Matchable<String> {
	private static final long serialVersionUID = 1L;
	private double repairPlanCost;

	/**
	 * @param manufacturer
	 * @param model
	 * @param applianceID
	 * @param price
	 * @param repairPlanCost
	 */
	public WasherDryer(String manufacturer, String model, String applianceID, double price, double repairPlanCost) {
		super(manufacturer, model, applianceID, price);
		this.repairPlanCost = repairPlanCost;
	}

	/**
	 * @return repairPlanCost of the WasherDryer0
	 */
	public double getRepairPlanCost() {
		return repairPlanCost;
	}

	@Override
	public void accept(ApplianceVisitor visitor) {
		visitor.visit(this);
	}

}
