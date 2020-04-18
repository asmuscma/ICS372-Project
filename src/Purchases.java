
import java.io.Serializable;
import java.util.Calendar;

public class Purchases extends Order implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;

	public Purchases(String orderID, String customerID, String applianceID, double orderCost, int quantity,
			Calendar date) {
		super(orderID, customerID, applianceID, orderCost, quantity, date);
	}

	@Override

	public boolean matches(String key) {
		return this.getID().equals(key);
	}

}
