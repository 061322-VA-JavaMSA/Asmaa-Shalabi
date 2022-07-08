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

@Entity
@Table(name="rem_type")
public class Rem_type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String r_type;
	
	
	public Rem_type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return r_type;
	}
	public void setType(String r_type) {
		this.r_type = r_type;
	}
	
	@Override
	public String toString() {
		return "rem_status [id=" + id + ", type=" + r_type + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(r_type, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rem_type other = (Rem_type) obj;
		return Objects.equals(r_type, other.r_type) && id == other.id ;
	}
}