package someKindOfShop.service;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import someKindOfShop.DAO.OfferDAO;
import someKindOfShop.DAO.OfferPostgres;
import someKindOfShop.shoppingList.Items;
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
	public int getAmount(int cId,int iId) {
		return td.getAmount(cId,iId);
	}
	public List<Offers> getAcceptedOffers(){
		return td.retrieveAcceptedOffers();
	}
	public boolean seDate(int cId,int iId,Date ld) {
		return td.setAcceptedDate(cId,iId,ld);
	}
	public List<Integer> retrieveWeeklyPayments(Date sd,Date ed){
		return td.retrieveWeeklyPay(sd,ed);
	}
	public List<Items> getCustomerItem(int userId) {
		return td.retrieveItemByUserId(userId);
		// TODO Auto-generated method stub
	
	}
	public int allPayments() {
		return td.sumOfPayments();
	}
}
