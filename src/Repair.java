import java.io.Serializable;

public class Repair extends Order implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;
	boolean active;
	boolean repairable;

	public Repair(String customerID, String applianceID, double orderCost, int quantity) {
		super(customerID, applianceID, orderCost, quantity);
		this.active = true;
		this.repairable = false;
	}

	public boolean getActive() {
		return active;
	}
}
