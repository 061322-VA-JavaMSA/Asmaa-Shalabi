package com.revature.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Employee;

import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmployeeHibernate implements EmployeeDAO {

	@Override
	public Employee insertEmployee(Employee u) {
		u.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();
			
		} catch(ConstraintViolationException e) {
			//log it
			
		}
		return u;
	}

	@Override
	public Employee getUserById(int id) {
		Employee user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			user = s.get(Employee.class, id);
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
	public Employee getUserByUsername(String username) {
		Employee user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			// SELECT * FROM USERS WHERE USERNAME = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			// define entity to be searched
			Root<Employee> root = cq.from(Employee.class);
			
			//define conditions
			Predicate predicateForUsername = cb.equal(root.get("username"), username);
//			Predicate predicateForSomethingElse = cb.equal(root.get("password"), password);
//			Predicate predicateFromUnameAndPass = cb.and(predicateForUsername, predicateForSomethingElse);
			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			user = (Employee) s.createQuery(cq).getSingleResult();
		}
		
		return user;
	}

	@Override
	public List<Employee> getUsers() {
		List<Employee> users = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from Employee", Employee.class).list();
		}
		
		return users;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		Employee x = new Employee();
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			
			Employee emp = (Employee) s.get(Employee.class, e.getId());
			
			emp.setUsername(e.getUsername());
			emp.setFirst_name(e.getFirst_name());
			emp.setLast_name(e.getLast_name());
			emp.setEmail(e.getEmail());
			emp.setRole(e.getRole());
			emp.setPassword(e.getPassword());
			s.merge(emp);
			tx.commit();
			x = emp;
			System.out.println(x);
		} catch (HibernateException e1) {

			e1.printStackTrace();
			
		}
		return x;}

	

}