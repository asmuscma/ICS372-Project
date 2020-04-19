import java.io.Serializable;
import java.util.Calendar;

public class BackOrder extends Order implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;
	boolean backOrderStatus = false;

	public BackOrder(String orderID, String customerID, String applianceID, double orderCost, int quantity,
			Calendar date) {
		super(orderID, customerID, applianceID, orderCost, quantity, date);
	}

	public void setBackOrderStatus(boolean status) {
		backOrderStatus = status;
	}

	public boolean getBackOrderStatus() {
		return backOrderStatus;
	}

	@Override
	public boolean matches(String key) {
		return this.getID().equals(key);
	}

}
