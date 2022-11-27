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

public class MenuOrderServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printer = response.getWriter();
        response.setContentType("text/html");

        MenuDataService menu = new MenuDataService();
        List<MenuItem> menuItems = menu.getFullMenu();

        printer.println("<html><body><h1>Main Menu Servlet</h1>");
        printer.println("<h6>" + new Date().toLocaleString() + "</h6>");
        printer.println("<h2>Pedido</h2>");
        printer.println("<form action='orderReceived.html' method='POST'><ul>");
        for (MenuItem menuItem : menuItems) {
            printer.println("<li>" + menuItem + "<input type='text' name='item_"+ (menuItem.getId()-1) +"'/></li>");
        }
        printer.println("</ul><hr><input type='submit' />");
        printer.println("</form></body></html>");
        printer.close();
    }
}
