package someKindOfShop.shoppingList;

import java.util.Objects;

public class Offers {
	private int customerId;
	private int itemId;
	 private int amount;
	 private boolean accepted;
	public Offers(int customerId, int itemId, int amount) {
		this.customerId=customerId;
		this.itemId=itemId;
		this.amount=amount;
	}
	public Offers(int itemId, int bid) {
		this.itemId=itemId;
		this.amount=bid;
		// TODO Auto-generated constructor stub
	}
	
	public Offers() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Offers [c_id=" + customerId + ", itemId=" + itemId + ", amount=" + amount + ", accepted=" + accepted + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, customerId, itemId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offers other = (Offers) obj;
		return amount == other.amount && customerId == other.customerId && itemId == other.itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCustomerId() {
		// TODO Auto-generated method stub
		return this.customerId;
	}
	public int getItemId() {
		// TODO Auto-generated method stub
		return this.itemId;
	}
	public void setCustomerId(int int1) {
		// TODO Auto-generated method stub
		this.customerId = int1;
		
	}
	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	

}
