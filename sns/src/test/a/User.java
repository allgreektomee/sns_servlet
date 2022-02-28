package test.a;

public class User {
	
	private String name; 
	private Long age; 
	private String address;
	
	public User() {
//		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	/**
	 * @param name
	 * @param age
	 * @param address
	 */
	public User(String name, Long age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
}
