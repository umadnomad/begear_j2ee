package com.riccardofinazzi.j2ee.attributesandparams;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view/attributes_and_params/AttributesAndParamsServlet")
public class AttributesAndParamsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("action").equals("invia")) {
			req.setAttribute("requestInjection", "REQUEST INJECTION SUCCESS");
			req.getSession().setAttribute("sessionInjection", "SESSION INJECTION SUCCESS");
			RequestDispatcher view = req.getRequestDispatcher("view.jsp");
			view.forward(req, resp);
		}
	}
	
	

}
