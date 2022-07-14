
package com.revature.models;



import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

	@Entity
	@Table(name="rem")
	public class Rem {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private int amount;
		private String description;
		private String status;
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		/*@ManyToOne
	    @JoinColumn(name = "employee_id")
		private int employee_id;*/
		@Temporal(TemporalType.DATE)
		@Column(name="submitted_date")
		private Date submitted_date;
		@Temporal(TemporalType.DATE)
		@Column(name="resolved_date")
		private Date ressolved_date;
		private int employee_id;
		
		/*@ManyToOne
	    @JoinColumn(name = "status_id ")
		private int status_id ;
		@ManyToOne
	    @JoinColumn(name = "type_id")
		private int type_id;*/
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
		/*public int getEmployee_id() {
			return employee_id;
		}
		public void setEmployee_id(int employee_id) {
			this.employee_id = employee_id;
		}*/
		public Date getSubmitted_date() {
			return submitted_date;
		}
		public void setSubmitted_date(Date submitted_date) {
			
			this.submitted_date = submitted_date;
		}
		public Date getRessolved_date() {
			return ressolved_date;
		}
		public void setRessolved_date(Date ressolved_date) {
			this.ressolved_date = ressolved_date;
		}
		
		public void setEmployee_id(int manager_id) {
			this.employee_id = manager_id;
		}
		/*public int getStatus_id() {
			return status_id;
		}
		public void setStatus_id(int status_id) {
			this.status_id = status_id;
		}
		public int getType_id() {
			return type_id;
		}
		public void setType_id(int type_id) {
			this.type_id = type_id;
		}*/
		@Override
		public int hashCode() {
			return Objects.hash(amount, description,  id,  employee_id,
					ressolved_date, submitted_date,status);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Rem other = (Rem) obj;
			return amount == other.amount && Objects.equals(description, other.description)
					
					 && id == other.id
					 && employee_id == other.employee_id
							 && status == other.status
					&& Objects.equals(ressolved_date, other.ressolved_date) 
					&& Objects.equals(submitted_date, other.submitted_date) ;
		}
		@Override
		public String toString() {
			return "Rem [id=" + id + ", amount=" + amount + ", description=" + description 
					+  ", employee_id=" + ""
					+ ", submitted_date=" + submitted_date + ", ressolved_date=" + ressolved_date + ", manager_id="
					+ employee_id + ", status=" + status + ", type_id=" + "" + "]";
		}
		public int getEmployee_id() {
			
			return employee_id;
		}
		
		
		
	}


