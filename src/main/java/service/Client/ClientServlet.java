package service.Client;

import dao.ClientDao;
import entity.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nicolas on 16/06/14.
 */
public class ClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("action")==null)
        {
            //System.out.println(request.getParameter("action").isEmpty());
            ClientDao clientDao = new ClientDao();
            request.setAttribute("clients", clientDao.getAll());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Client/client.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            String action = request.getParameter("action").toString();
            switch (action)
            {
                case  "infoClient" :
                    Client client = new Client();
                    client.setCliId(Long.valueOf(request.getParameter("id")));
                    ClientDao clientDao = new ClientDao();
                    request.setAttribute("client", clientDao.getOne(client));
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Client/infoClient.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        }
    }
}
