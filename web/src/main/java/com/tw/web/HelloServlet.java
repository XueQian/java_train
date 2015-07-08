package com.tw.web;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.core.Service;
import com.tw.core.User;

public class HelloServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;character=utf-8");

        Service service = new Service();
        List<User> userList = service.getUser();

        PrintWriter out = res.getWriter();

        for(int i = 0;i<userList.size();i++){

            out.println(userList.get(i).getName()+"  "+userList.get(i).getSex()+"  "+userList.get(i).getAge()+"  "+userList.get(i).getAddress());
        }
        out.close();
    }
}