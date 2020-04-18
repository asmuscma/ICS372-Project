import java.io.Serializable;
/*import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;*/

public class Customer implements Serializable {
	//private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String id;
	//private static final String MEMBER_STRING = "M";
	
	public Customer(String name, String phone, String id){
		this.name = name;
		this.phone = phone;
		this.id = id;
		//id = MEMBER_STRING + (CustomerIdServer.instance()).getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
