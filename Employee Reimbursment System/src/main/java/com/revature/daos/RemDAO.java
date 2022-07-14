package com.revature.daos;

import java.util.List;

import com.revature.models.Rem;

public interface RemDAO {


		Rem insertRem(Rem e);
		Rem getRemById(int id);

		List<Rem> getRems();
		Rem getRemByEmployee_Id(int id);
		
	

}
