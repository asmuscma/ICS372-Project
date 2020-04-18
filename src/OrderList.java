import java.io.IOException;

/**
 * @author Colin Asmus, Phong Chang, Ronald Marita, Zion Tran
 *
 */
public class OrderList extends ItemList<Order, String> {
	private static final long serialVersionUID = 1L;
	private static OrderList orderList;

	/**
	 * Singleton
	 */
	private OrderList() {
	}

	/**
	 * @return support singleton
	 */
	public static OrderList instance() {
		if (orderList == null) {
			return (orderList = new OrderList());
		} else {
			return orderList;
		}
	}

	/* (non-Javadoc)
	 * @see ItemList#search(java.lang.Object)
	 */
	@Override
	public Order search(String orderId) {
		return super.search(orderId);
	}

	/**
	 * 
	 * @param order
	 * @return true if order added
	 */
	public boolean insertOrder(Order order) {
		return super.add(order);
	}

	/**
	 * Write
	 * @param output
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream output) throws IOException {
		output.defaultWriteObject();
		output.writeObject(orderList);
	}

	/**
	 * Read
	 * @param input
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream input) throws IOException, ClassNotFoundException {
		input.defaultReadObject();
		if (orderList == null) {
			orderList = (OrderList) input.readObject();
		} else {
			input.readObject();
		}
	}
}
