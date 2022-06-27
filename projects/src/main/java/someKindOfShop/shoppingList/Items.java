package someKindOfShop.shoppingList;

import java.util.Objects;

import someKindOfShop.user.Customer;

public class Items {
	private int id;
	private String name;
	private int price;
	private boolean owendStatus;
	private int customerId;
	int count;
	public Items( String name, int price) {
		super();
		
		this.name = name;
		this.price = price;
	}
	public Items(int itemId) {
		this.id=itemId;
	}
	public Items() {
		// TODO Auto-generated constructor stub
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int i) {
		this.price = i;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(count, id, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return count == other.count && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price);
	}
	public void setOwenedStatus(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setUserAssigned(Customer u) {
		// TODO Auto-generated method stub
		
	}
	public boolean isOwendStatus() {
		return owendStatus;
	}
	public void setOwendStatus(boolean owendStatus) {
		this.owendStatus = owendStatus;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	

}
