import java.io.IOException;

public class OrderList extends ItemList<Order, String> {
	private static final long serialVersionUID = 1L;
	private static OrderList orderList;

	private OrderList() {
	}

	public static OrderList instance() {
		if (orderList == null) {
			return (orderList = new OrderList());
		} else {
			return orderList;
		}
	}

	@Override
	public Order search(String orderId) {
		return super.search(orderId);
	}

	public boolean insertOrder(Order order) {
		return super.add(order);
	}

	private void writeObject(java.io.ObjectOutputStream output) throws IOException {
		output.defaultWriteObject();
		output.writeObject(orderList);
	}

	private void readObject(java.io.ObjectInputStream input) throws IOException, ClassNotFoundException {
		input.defaultReadObject();
		if (orderList == null) {
			orderList = (OrderList) input.readObject();
		} else {
			input.readObject();
		}
	}
}
