package someKindOfShop.shoppingList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingSystem {
	
	 public static Object out;
	HashMap<Integer,Items> map=new HashMap<>();
	 List<Offers> offerList=new ArrayList<>();
	 List<Items> shopList= new ArrayList<>();
	 public ShoppingSystem() {
			super();
		}
	 public void addOffer(int customerId, int itemId, int amount) {
		 Offers nOffer= new Offers(customerId,itemId,amount);
		 offerList.add(nOffer);
	 }
	 public void addshopListItem(Items i) {
		 shopList.add(i);
	 }
	 public List<Items> getShopList(){
			return shopList;
			
		}
	

}
