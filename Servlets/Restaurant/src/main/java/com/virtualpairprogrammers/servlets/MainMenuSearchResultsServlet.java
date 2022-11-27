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

public class MainMenuSearchResultsServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printer = response.getWriter();
        response.setContentType("text/html");

        String searchText = request.getParameter("searchText");

        MenuDataService menu = new MenuDataService();
        List<MenuItem> menuItems = menu.find(searchText);

        printer.println("<html><body><h1>Main Menu Servlet</h1>");
        printer.println("<h6>" + new Date().toLocaleString() + "</h6>");
        printer.println("<h2>Seu Menu com " + searchText + "!!</h2><ul>");
        if (menuItems.size() > 0) {
            for (MenuItem menuItem : menuItems) {
                printer.println("<li>");
                printer.println("<h3>" + menuItem + "</h3>");
                printer.println("<p>" + menuItem.getDescription() + "</p>");
                printer.println("</li>");
            }
        } else {
            printer.println("<p>Desculpe, você disse " + searchText + "? Sorry, mas nenhum produto com o termo selecionado.</p>");
        }
        printer.println("</ul></body></html>");
        printer.close();
    }
}
