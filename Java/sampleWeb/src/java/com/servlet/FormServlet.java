// servlet using post method and RequestDispatcher usage with include and forward

package com.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;

public class FormServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //out.println("Hello World !");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //out.println("Student Details");
        
        String serial = req.getParameter("serial");
        String name = req.getParameter("name");
        String subject = req.getParameter("subject");
        String cond = req.getParameter("cond");
        
        if(cond != null){
            RequestDispatcher rd = req.getRequestDispatcher("display");
            rd.forward(req, resp);
        }
        else{
            out.println("<p style=\"color:red;\">Please enter details</p>");
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }        
    }    
}
