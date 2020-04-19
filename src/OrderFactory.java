
public class OrderFactory {
	private static OrderFactory factory;

	/**
	 * Private for singleton
	 */

	private OrderFactory() {

	}

	/**
	 * Returns the only instance of the class.
	 * 
	 * @return the instance
	 */
	public static OrderFactory instance() {
		if (factory == null) {
			factory = new OrderFactory();
		}
		return factory;
	}

	/**
	 * Creates an appliance object and returns it.
	 * 
	 * @param type        the type of order
	 * 
	 * @param model       model of the appliance
	 * @param price       price of the model
	 * @param ID          the ID of the appliance
	 * @param proprietary a number for the specific appliance type WasherDryer =
	 *                    Repair Cost Furnace = Heating Capacity Refrigerator=
	 *                    Storage Capacity
	 * @return the item that was created
	 */
	public Order createOrder(int type, String customerID, String applianceID, double orderCost, int quantity) {
		switch (type) {
		case Company.PURCHASE:
			return new Purchase(customerID, applianceID, orderCost, quantity);
		case Company.BACKORDER:
			return new BackOrder(customerID, applianceID, orderCost, quantity);
		case Company.REPAIRPLAN:
			return new Repair(customerID, applianceID, orderCost, quantity);
		default:
			return null;
		}
	}

}
