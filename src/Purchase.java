
import java.io.Serializable;

public class Purchase extends Order implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;

	public Purchase(String customerID, String applianceID, double orderCost, int quantity) {
		super(customerID, applianceID, orderCost, quantity);
	}

	@Override

	public boolean matches(String key) {
		return this.getId().equals(key);
	}

}
