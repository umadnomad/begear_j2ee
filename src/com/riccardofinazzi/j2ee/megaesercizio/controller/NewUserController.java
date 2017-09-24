package com.riccardofinazzi.j2ee.megaesercizio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.riccardofinazzi.j2ee.megaesercizio.controller.persistencedelegate.PersistenceDelegate;
import com.riccardofinazzi.j2ee.megaesercizio.controller.persistencedelegate.ServiceType;
import com.riccardofinazzi.j2ee.megaesercizio.model.User;

@WebServlet("/view/megaesercizio/NewUserController")
public class NewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "user.jsp";
	private static String LIST_USER = "listuser.jsp";
	
	private PersistenceDelegate persistence;

	public NewUserController() {
		
		super();
		persistence = new PersistenceDelegate();
		persistence.setServiceType(ServiceType.JDBC);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");
		String[] tokens = action.split("_");

		if (tokens.length > 1) {
			switch (tokens[0]) {
			case "update":
				forward = INSERT_OR_EDIT;
				User user = persistence.getUserById(tokens[1]);
				request.setAttribute("user", user);
				break;
			case "delete":
				persistence.deleteUser(tokens[1]);
				forward = LIST_USER;
				request.setAttribute("users", persistence.getAllUsers());
			}
		} else if (tokens[0].equals("insert")) {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}