import java.io.Serializable;
import java.util.Calendar;

public class BackOrder extends Order implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;
	boolean backOrderFulfilled = false;

	public BackOrder(String customerID, String applianceID, double orderCost, int quantity, Calendar date) {
		super(customerID, applianceID, orderCost, quantity, date);
	}

	public void setBackOrderStatus(boolean fulfilled) {
		backOrderFulfilled = fulfilled;
	}

	public boolean getBackOrderStatus() {
		return backOrderFulfilled;
	}

	@Override
	public boolean matches(String key) {
		return this.getId().equals(key);
	}

}
