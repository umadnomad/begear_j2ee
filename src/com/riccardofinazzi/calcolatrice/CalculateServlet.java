package com.riccardofinazzi.calcolatrice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// mappatura effettuata nel web.xml
public class CalculateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException,
																					IOException {

		Integer n1 = Integer.parseInt(request.getParameter("operand1"));
		Integer n2 = Integer.parseInt(request.getParameter("operand2"));
		String opt = request.getParameter("operation");

		Integer result = null;

		switch (opt) {
		case "multiply":
			result = n1 * n2;
			break;
		case "divide":
			result = n1 / n2;
			break;
		case "sum":
			result = n1 + n2;
			break;
		case "subtract":
			result = n1 - n2;
		}

		// aggiungo un attributo alla request
		request.setAttribute("result", result);

		// richiamo la stessa pagina
		RequestDispatcher req = request.getRequestDispatcher("index.jsp");
		// le inoltro la response
		req.forward(request, response);

	}
}
