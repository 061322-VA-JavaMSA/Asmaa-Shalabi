package someKindOfShop.service;


import java.util.List;

import someKindOfShop.DAO.OfferDAO;
import someKindOfShop.DAO.OfferPostgres;

import someKindOfShop.shoppingList.Offers;

public class OfferService {
private OfferDAO td = new OfferPostgres();
	
	public Offers getItemById(int id){
		//
		return td.retrieveOfferById(id);
	}
	public Offers createOffer(int c,int i,int amount) {
		Offers o = new Offers(c,i,amount);
		System.out.println(i);
		return td.addOffer(o);
	}
	public List<Offers> getOffer(int id) {
		return td.retrieveOfferByUserId(id);
	}
	public List<Offers> getoffers(){
		return td.retrieveOffers();
	}
	public boolean updateOffer(int cId, int iId,boolean acc) {
		return td.updateAcceptedState( cId,  iId,acc);
	}
	public boolean rejectOffer(int id) {
		return td.rejectAllOffersByItemId(id);
	}

}
