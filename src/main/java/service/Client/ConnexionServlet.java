package service.Client;

import dao.ClientDao;
import entity.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by nicolas on 16/06/14.
 */

public class ConnexionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client clientAuth = new Client();
        clientAuth.setCliMail(request.getParameter("email"));
        clientAuth.setCliMotdepasse(request.getParameter("pwd"));
        ClientDao cli = new ClientDao();
        Client user = cli.authentification(clientAuth);
        System.out.print(user.getCliNom());
        if(user != null){
            HttpSession mySession = request.getSession();
            mySession.setAttribute("user",user);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Client/auth.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Client/auth.jsp");
        dispatcher.forward(request, response);
    }
}
