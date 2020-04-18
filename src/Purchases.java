
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Purchases implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderID;
	private String customerID;
	private String applianceID;
	private double orderCost;
	private int quantity;
	private Calendar date;

	public Purchases(String orderID, String customerID, String applianceID, double orderCost, int quantity, Calendar date) {
		this.orderID = orderID;
		this.customerID = customerID;
		this.applianceID = applianceID;
		this.orderCost = orderCost;
		this.quantity = quantity;
		date = new GregorianCalendar();
		date.setTimeInMillis(System.currentTimeMillis());
	}

	public boolean onDate(Calendar date) {
		return ((date.get(Calendar.YEAR) == this.date.get(Calendar.YEAR))
				&& (date.get(Calendar.MONTH) == this.date.get(Calendar.MONTH))
				&& (date.get(Calendar.DATE) == this.date.get(Calendar.DATE)));
	}

	public String getID() {
		return orderID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getApplianceID() {
		return applianceID;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public String getDate() {
		return date.get(Calendar.MONTH) + "/" + date.get(Calendar.DATE) + "/" + date.get(Calendar.YEAR);
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Order [customerID=" + customerID + ", applianceID=" + applianceID + ", orderCost=" + orderCost + "]";
	}

	public boolean matches(String key) {
		return this.getID().equals(key);
	}

}
