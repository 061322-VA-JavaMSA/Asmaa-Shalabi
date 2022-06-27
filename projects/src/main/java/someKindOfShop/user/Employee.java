package someKindOfShop.user;

import java.util.Objects;

public class Employee {
	private String uname;
	private String pass;
	private int id;
	public Employee(String uname, String pass) {
		super();
		this.uname = uname;
		this.pass = pass;
	}
	public Employee() {
		
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, pass, uname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(pass, other.pass) && Objects.equals(uname, other.uname);
	}
	@Override
	public String toString() {
		return "Employee [uname=" + uname + ", pass=" + pass + ", id=" + id + "]";
	}
	

}
