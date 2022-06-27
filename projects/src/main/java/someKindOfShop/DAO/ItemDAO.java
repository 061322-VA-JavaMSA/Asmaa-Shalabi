package someKindOfShop.DAO;

import java.util.List;

import someKindOfShop.shoppingList.Items;

public interface ItemDAO {

	Items addItem(Items t);
	List<Items> retrieveItems();
	Items retrieveItemById(int id);
	List<Items> retrieveItemByUserId(int id);
	boolean updateItem(Items t);
	boolean deleteItem(int id);
	boolean updateItemCustomerId(Items t,int id);
	boolean deleteItemByName(String name);
	boolean updateItemById(Items t, int cId, int iId);

}
