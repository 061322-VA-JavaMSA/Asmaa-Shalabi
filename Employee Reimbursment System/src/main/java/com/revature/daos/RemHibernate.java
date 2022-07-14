package com.revature.daos;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Employee;
import com.revature.models.Rem;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class RemHibernate implements RemDAO{
	@Override
	public Rem insertRem(Rem u) {
		u.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			java.util.Date utilDate= new java.util.Date();
			java.sql.Date subDate= new java.sql.Date(utilDate.getTime());
			u.setId(id);
			u.setSubmitted_date(subDate);
			u.setStatus("Pending");
			tx.commit();
			
		} catch(ConstraintViolationException e) {
			//log it
			
		}
		return u;
	}

	@Override
	public Rem getRemById(int id) {
		Rem user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			user = s.get(Rem.class, id);
		}
		
//		try(Session s = HibernateUtil.getSessionFactory().openSession();){
//			String sql = "select * from users where id = :id ;";
//			NativeQuery<User> nq = s.createNativeQuery(sql, User.class);
//			nq.setParameter("id", id);
//			user = nq.getSingleResult();
//		}
		
		return user;
	}

	@Override
	public Rem getRemByEmployee_Id(int id) {
		Rem rem = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			// SELECT * FROM USERS WHERE USERNAME = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Rem> cq = cb.createQuery(Rem.class);
			// define entity to be searched
			Root<Rem> root = cq.from(Rem.class);
			
			//define conditions
			Predicate predicateForUsername = cb.equal(root.get("employee_id"), id);
//			Predicate predicateForSomethingElse = cb.equal(root.get("password"), password);
//			Predicate predicateFromUnameAndPass = cb.and(predicateForUsername, predicateForSomethingElse);
			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			rem = (Rem) s.createQuery(cq).getSingleResult();
		}
		
		return rem;
	}

	@Override
	public List<Rem> getRems() {
		List<Rem> rems = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			rems = s.createQuery("from Rem", Rem.class).list();
		}
		
		return rems;

}
}