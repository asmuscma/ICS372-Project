
public class ApplianceFactory {
	private static ApplianceFactory factory;

	/**
	 * Private for singleton
	 */

	private ApplianceFactory() {

	}

	/**
	 * Returns the only instance of the class.
	 * 
	 * @return the instance
	 */
	public static ApplianceFactory instance() {
		if (factory == null) {
			factory = new ApplianceFactory();
		}
		return factory;
	}

	/**
	 * Creates an appliance object and returns it.
	 * 
	 * @param type         the type of appliance
	 * @param manufacturer manufacturer of the appliance
	 * @param model        model of the appliance
	 * @param price        price of the model
	 * @param ID           the ID of the appliance
	 * @param proprietary  a number for the specific appliance type WasherDryer =
	 *                     Repair Cost Furnace = Heating Capacity Refrigerator=
	 *                     Storage Capacity
	 * @return the item that was created
	 */
	public Appliance createAppliance(int type, String manufacturer, String model, double price, double proprietary) {
		switch (type) {
		case Company.WASHERDRYER:
			return new WasherDryer(manufacturer, model, price, proprietary);
		case Company.FURNACE:
			return new Furnace(manufacturer, model, price, proprietary);
		case Company.REFRIGERATOR:
			return new Furnace(manufacturer, model, price, proprietary);
		default:
			return null;
		}
	}

}
