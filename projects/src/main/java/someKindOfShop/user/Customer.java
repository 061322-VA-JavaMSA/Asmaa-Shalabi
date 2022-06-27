package someKindOfShop.user;

import java.util.Objects;

public class Customer {
	private String uname;
	private String pass;
	private int id;
	private int balance;
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
	@Override
	public String toString() {
		return "Customer [uname=" + uname + ", pass=" + pass + ", id=" + id + "]";
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
		Customer other = (Customer) obj;
		return id == other.id && Objects.equals(pass, other.pass) && Objects.equals(uname, other.uname);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer(String uname, String pass) {
		super();
		this.uname = uname;
		this.pass = pass;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
