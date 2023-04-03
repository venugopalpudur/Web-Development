package com.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;

public class DisplayServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String serial = req.getParameter("serial");
        String name = req.getParameter("name");
        String subject = req.getParameter("subject");
        String cond = req.getParameter("cond");
        
        out.println("<p>Serial No :"+serial+"</p>");
        out.println("<p>Student Name :"+name+"</p>");
        out.println("<p>Subject Name :"+subject+"</p>");
    }
    
}
