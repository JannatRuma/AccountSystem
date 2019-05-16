
public class Employee extends Account {
	String id;
	String name;
	String address;
	public Employee(String id, String name, String address,String accountNumber,String type,String balance) {
		super(accountNumber,type,balance);
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	
}
