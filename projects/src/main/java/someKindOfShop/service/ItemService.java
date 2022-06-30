package someKindOfShop.service;

import java.util.List;

import someKindOfShop.DAO.ItemDAO;
import someKindOfShop.DAO.ItemPostgres;
import someKindOfShop.shoppingList.Items;

public class ItemService {
private ItemDAO td = new ItemPostgres();
	
	public List<Items> getItem(){
		//
		return td.retrieveItems();

}
	public Items getItemById(int id) {
		return td.retrieveItemById(id);
	}
	public List<Items> getCustomerItem(int id) {
		return td.retrieveItemByUserId(id);
	}
	//public boolean updateItemCustomerId(Items t, int cId) 
	public boolean updateCId(Items t, int cId) {
		return td.updateItemCustomerId(t,cId);
	}
	public boolean updateOwnedState(int cId,int iId) {
		Items t = getItemById(iId);
		return td.updateItemById(t,cId,iId);
	}
	public Items addItems(Items t) {
		return td.addItem(t);
	}
}