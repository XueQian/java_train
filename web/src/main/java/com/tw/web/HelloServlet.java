package com.tw.web;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.core.Service;
import com.tw.core.User;

public class HelloServlet extends HttpServlet {

    private static String USERLIST = "/userList.jsp";
    private static String UPDATEUSER = "/updateUser.jsp";

    private Service service = new Service();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String forward;
        String action = req.getParameter("action");

        List<User> userList = service.getUsers();

        if ("delete".equalsIgnoreCase(action)) {

            int id = Integer.parseInt(req.getParameter("id"));
            service.deleteUser(id);
            forward = USERLIST;
            req.setAttribute("users", service.getUsers());

        } else if ("update".equalsIgnoreCase(action)) {

            forward = UPDATEUSER;
            int userId = Integer.parseInt(req.getParameter("id"));
            User user = service.getUserById(userId);
            req.setAttribute("user", user);

        } else {

            forward = USERLIST;
            req.setAttribute("users", userList);
        }
        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, res);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = new User();

        String userId = request.getParameter("id");
        user.setName(request.getParameter("name"));
        user.setSex(request.getParameter("sex"));
        user.setAddress(request.getParameter("address"));
        user.setAge(Integer.parseInt(request.getParameter("age")));

        if (userId != null) {

            user.setId(Integer.parseInt(userId));
            service.updateUser(user);
        } else {

            service.addUser(user);
        }

        RequestDispatcher view = request.getRequestDispatcher(USERLIST);
        request.setAttribute("users", service.getUsers());
        view.forward(request, response);
    }
}

