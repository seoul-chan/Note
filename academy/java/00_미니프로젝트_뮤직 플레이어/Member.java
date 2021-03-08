package music.play.list.model;

import java.io.Serializable;

public class Member implements Serializable{
	
	private static final long serialVersionUID = 5720041424760320944L;
	private String name;
	private String id;
	private String password;
	private String phone;
	private String address;
	
	public Member() {	}

	public Member(String name, String id, String password, String phone, String address) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	
	public String getName() {return name;}
	public String getId() {return id;}
	public String getPassword() {return password;}
	public String getPhone() {return phone;}
	public String getAddress() {return address;}
	
	public void setName(String name) {this.name=name;}
	public void setId(String id) {this.id=id;}
	public void setPassword(String password) {this.password=password;}
	public void setPhone(String phone) {this.phone=phone;}
	public void setAddress(String address) {this.address=address;}
	
	@Override
	public String toString() {
		return "["+name+", "+id+", "+password+", "+phone+", "+address+"]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Member) {
			Member m = (Member)o;
			if(id.equals(m.getId()) && password.equals(m.getPassword())) 
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (id+password).hashCode();
	}
}
