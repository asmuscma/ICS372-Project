import java.io.IOException;

public class CustomerList extends ItemList<Customer, String> {
	private static CustomerList customerList;


	private CustomerList() {
	}

	public static CustomerList instance() {
		if (customerList == null) {
			return (customerList = new CustomerList());
		} else {
			return customerList;
		}
	}


	@Override
	public Customer search(String CustomerId) {
		return super.search(CustomerId);
	}


	public boolean insertCustomer(Customer Customer) {
		return super.add(Customer);
	}

	private void writeObject(java.io.ObjectOutputStream output)
			throws IOException {
		output.defaultWriteObject();
		output.writeObject(customerList);
	}


	private void readObject(java.io.ObjectInputStream input)
			throws IOException, ClassNotFoundException {
		input.defaultReadObject();
		if (customerList == null) {
			customerList = (CustomerList) input.readObject();
		} else {
			input.readObject();
		}
	}
}