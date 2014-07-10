package service;

import dao.ClientDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nicolas on 16/06/14.
 */
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientDao clientDao = new ClientDao();
        request.setAttribute("clients", clientDao.getAll());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(request, response);
    }
}
