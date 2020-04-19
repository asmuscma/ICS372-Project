
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
	private String orderId;
	private String customerID;
	private String applianceID;
	private double orderCost;
	private int quantity;
	private Calendar date;
	private static final String ORDER_STRING = "R";

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
	public Order(String customerID, String applianceID, double orderCost, int quantity, Calendar date) {
		this.customerID = customerID;
		this.applianceID = applianceID;
		this.orderCost = orderCost;
		this.quantity = quantity;
		orderId = ORDER_STRING + (OrderIdServer.instance().getId());
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
	public String getId() {
		return orderId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [customerID=" + customerID + ", applianceID=" + applianceID + ", orderCost=" + orderCost + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Matchable#matches(java.lang.Object)
	 */
	@Override
	public boolean matches(String key) {
		return this.getId().equals(key);
	}

}
