import java.io.Serializable;
import java.util.Calendar;

public class Repairs extends Order implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;
	boolean active;
	boolean repairable;

	public Repairs(String orderID, String customerID, String applianceID, double orderCost, int quantity,
			Calendar date) {
		super(orderID, customerID, applianceID, orderCost, quantity, date);
		this.active = true;
	}

	public boolean getActive() {
		return active;
	}

	public boolean cancelPlan() {
		this.active = false;
		return active;
	}
}
