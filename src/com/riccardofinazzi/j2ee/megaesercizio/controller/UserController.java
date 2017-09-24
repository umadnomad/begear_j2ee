package com.riccardofinazzi.j2ee.megaesercizio.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.riccardofinazzi.j2ee.megaesercizio.controller.persistencedelegate.PersistenceDelegate;
import com.riccardofinazzi.j2ee.megaesercizio.controller.persistencedelegate.ServiceType;
import com.riccardofinazzi.j2ee.megaesercizio.model.User;

@WebServlet("/view/megaesercizio/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String LIST_USER = "listuser.jsp";
    
    private PersistenceDelegate persistence;
 
    public UserController() {
        super();
		persistence = new PersistenceDelegate();
		persistence.setServiceType(ServiceType.JDBC);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", persistence.getAllUsers());
        }
 
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUname(request.getParameter("uname"));
        user.setPassword(request.getParameter("pass"));
        try {
            Date reg = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("dob"));
            System.out.println("registration @ "+ reg);
            user.setRegisteredon(reg);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("email"));
        String userid = request.getParameter("uname");
//        if(userid == null || userid.isEmpty())
//        {
//            dao.addUser(user);
//        }
//        else
//        {
            user.setUname(userid);
            persistence.checkUser(user);
//        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", persistence.getAllUsers());
        view.forward(request, response);
    }
}