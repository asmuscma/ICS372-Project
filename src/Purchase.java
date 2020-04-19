
import java.io.Serializable;
import java.util.Calendar;

public class Purchase extends Order implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;

	public Purchase(String customerID, String applianceID, double orderCost, int quantity, Calendar date) {
		super(customerID, applianceID, orderCost, quantity, date);
	}

	@Override

	public boolean matches(String key) {
		return this.getId().equals(key);
	}

}
