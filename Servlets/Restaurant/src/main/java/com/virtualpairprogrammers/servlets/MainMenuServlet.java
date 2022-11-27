package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class MainMenuServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printer = response.getWriter();
        response.setContentType("text/html");

        MenuDataService menu = new MenuDataService();
        List<MenuItem> menuItems = menu.getFullMenu();

        printer.println("<html><body><h1>Main Menu Servlet</h1>");
        printer.println("<h6>" + new Date().toLocaleString() + "</h6>");
        printer.println("<h2>Menu</h2><ul>");
        for (MenuItem menuItem : menuItems) {
            printer.println("<li>" + menuItem + "</li>");
        }
        printer.println("</ul></body></html>");
        printer.close();
    }
}
