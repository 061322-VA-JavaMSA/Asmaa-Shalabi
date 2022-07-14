package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Employee;
import com.revature.models.Rem;
import com.revature.models.Role;

public class RemDTO {

	private int id;
	private int amount;
	private String description;
	private int employee_id;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RemDTO(Rem e) {
		id= e.getId();
		amount=e.getAmount();
		description= e.getDescription();
		employee_id= e.getEmployee_id();
		status = e.getStatus();
		
	}

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
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, description, employee_id, id,status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemDTO other = (RemDTO) obj;
		return amount == other.amount && Objects.equals(description, other.description)
				&& employee_id == other.employee_id && id == other.id && status == other.status;
	}
	@Override
	public String toString() {
		return "RemDTO [id=" + id + ", amount=" + amount + ", description=" + description + ", employee_id="
				+ employee_id + ", status=" + status + "]";
	}


	

	
	

}
