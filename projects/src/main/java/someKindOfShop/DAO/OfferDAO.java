package someKindOfShop.DAO;

import java.util.List;

import someKindOfShop.shoppingList.Items;
import someKindOfShop.shoppingList.Offers;

public interface OfferDAO {
	Offers addOffer(Offers f);
	List<Offers> retrieveOffers();
	Offers retrieveOfferById(int id);
	List<Offers> retrieveOfferByUserId(int id);
	
	boolean deleteOffer(int id);
	boolean updateAcceptedState(int cId, int iId, boolean acc);
	boolean rejectAllOffersByItemId(int iId);
	int getAmount(int cId, int iId);
	List<Offers> retrieveAcceptedOffers();
	

}
