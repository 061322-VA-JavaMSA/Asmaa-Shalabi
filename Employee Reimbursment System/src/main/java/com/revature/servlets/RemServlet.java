package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.dtos.RemDTO;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Rem;
import com.revature.models.Role;
import com.revature.services.RemService;
import com.revature.util.CorsFix;


public class RemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RemService us = new RemService();
	// object to convert to JSON format
	private ObjectMapper om = new ObjectMapper();

	/*-
	 * All GET request made to the /users endpoint are funneled to this doGet method
	 * 		- /users
	 * 			- returns all users
	 * 		- /users/{id}
	 * 			- returns a user of a specific id
	 * Have to determine which behavior to execute based on the URL request 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Specifying that the response content-type will be JSON
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.setContentType("text/html");
		//res.addHeader("Content-Type", "application/json");


		/*-
		 * Extra path information associated with the URL the client sent when it made this request
		 * 	- ie: 
		 * 		- "/1" if /users/1
		 * 		- null if /users
		 */
		String pathInfo = req.getPathInfo();

		// if pathInfo is null, the req should be to /users -> send back all users
		if (pathInfo == null) {

			/*-
			 *  HttpSession allows us to retrieve information placed in the session object passed in a previous HttpResponse 
			 *  	- in this case, the Session is set in the AuthServlet
			 */
			HttpSession session = req.getSession();

			if (session != null) {
				// retrieving users from db using UserService
				List<Rem> users = us.getRems();
				List<RemDTO> usersDTO = new ArrayList<>();

				// converting Users to UserDTOs for data transfer
				users.forEach(u -> usersDTO.add(new RemDTO(u)));

				// retrieving print writer to write to the Response body
				PrintWriter pw = res.getWriter();
				// writing toString representation of Users to body
				pw.write(om.writeValueAsString(usersDTO));

				pw.close();
			}else {
				// if the user making the request is not an admin
				res.sendError(401, "Unauthorized request.");
			}
		} else {
			// /1, /11, /{some-value}
			// Have to remove "/" to get the id to be retrieved
			int id = Integer.parseInt(pathInfo.substring(1));

			try (PrintWriter pw = res.getWriter()) {
				// retrieve user by id
				Rem u = us.getUserById(id);
				RemDTO uDTO = new RemDTO(u);

				// convert user to JSON and write to response body
				pw.write(om.writeValueAsString(uDTO));

				res.setStatus(200);
			} catch (UserNotFoundException e) {
				// return 404, user not found
				res.setStatus(404);
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		InputStream reqBody = req.getInputStream();
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		
		Rem newUser = om.readValue(reqBody, Rem.class);
		
		try {
			us.createRem(newUser);

			res.setStatus(201); // Status: Created
		} catch (UserNotCreatedException e) {
//			res.setStatus(400);
			res.sendError(400, "Unable to create new rem.");
			e.printStackTrace();
		}
	}
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		super.doOptions(req, resp);
		
	}
}