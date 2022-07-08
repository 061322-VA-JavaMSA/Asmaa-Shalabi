package com.revature.models;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//@Entity
//@Table(name="roles")
public enum Role {
	BASIC_USER, ADMIN
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	private String e_role;
//	
//	
//	public Role() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getE_role() {
//		return e_role;
//	}
//	public void setE_role(String e_role) {
//		this.e_role = e_role;
//	}
//	
//	@Override
//	public String toString() {
//		return "Role [id=" + id + ", role=" + e_role + "]";
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(e_role, id);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Role other = (Role) obj;
//		return Objects.equals(e_role, other.e_role) && id == other.id ;
//	}
}