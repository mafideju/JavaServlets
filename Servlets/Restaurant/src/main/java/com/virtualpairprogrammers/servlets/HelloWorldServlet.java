package com.virtualpairprogrammers.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printer = response.getWriter();
        response.setContentType("text/html");
        printer.println("<html><body><h1>Hello World</h1>");
        printer.println("<h6>" + new Date().toLocaleString() + "</h6>");
        printer.println("</body></html>");
        printer.close();
    }
}
