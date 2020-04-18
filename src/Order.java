
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Implements Orders
 * 
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public abstract class Order implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;
	private String orderID;
	private String customerID;
	private String applianceID;
	private double orderCost;
	private int quantity;
	private Calendar date;

	/**
	 * Order Constructor
	 * 
	 * @param orderID
	 * @param customerID
	 * @param applianceID
	 * @param orderCost
	 * @param quantity
	 * @param date
	 */
	public Order(String orderID, String customerID, String applianceID, double orderCost, int quantity, Calendar date) {
		this.orderID = orderID;
		this.customerID = customerID;
		this.applianceID = applianceID;
		this.orderCost = orderCost;
		this.quantity = quantity;
		date = new GregorianCalendar();
		date.setTimeInMillis(System.currentTimeMillis());
	}

	/**
	 * @param date
	 * @return
	 */
	public boolean onDate(Calendar date) {
		return ((date.get(Calendar.YEAR) == this.date.get(Calendar.YEAR))
				&& (date.get(Calendar.MONTH) == this.date.get(Calendar.MONTH))
				&& (date.get(Calendar.DATE) == this.date.get(Calendar.DATE)));
	}

	/**
	 * Getter for orderID
	 * 
	 * @return orderID
	 */
	public String getID() {
		return orderID;
	}

	/**
	 * Getter for customerID
	 * 
	 * @return customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * Getter for applianceID
	 * 
	 * @return applianceID
	 */
	public String getApplianceID() {
		return applianceID;
	}

	/**
	 * Getter for orderCost
	 * 
	 * @return orderCost
	 */
	public double getOrderCost() {
		return orderCost;
	}

	/**
	 * Getter for date
	 * 
	 * @return date
	 */
	public String getDate() {
		return date.get(Calendar.MONTH) + "/" + date.get(Calendar.DATE) + "/" + date.get(Calendar.YEAR);
	}

	/**
	 * Getter for quantity
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Order [customerID=" + customerID + ", applianceID=" + applianceID + ", orderCost=" + orderCost + "]";
	}

	@Override
	public boolean matches(String key) {
		return this.getID().equals(key);
	}

}
