
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
		if{factory == null) {
			factory = new ApplianceFactory();
		}
		return factory
	}
		
		/**
		 * Creates an appliance object and returns it.
		 * 
		 * @param type
		 * 			the type of appliance
		 * 
		 * @param 
		 */

}
