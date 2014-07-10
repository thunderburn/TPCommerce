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
 * Created by nicolas on 17/06/14.
 */
public class InscriptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDao clientDao = new ClientDao();
        if(clientDao.verifieSiUnMailExisteDeja(request.getParameter("mail")))
        {
            Client client = new Client();
            client.setCliNom(request.getParameter("nom"));
            client.setCliMail(request.getParameter("mail"));
            client.setCliPrenom(request.getParameter("prenom"));
            client.setCliMotdepasse(request.getParameter("mdp"));
            client.setCliType("USER");

            clientDao.save(client);
            request.setAttribute("success", "Votre compte à bien été créé, vous pouvez maintenant vous connecter...");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Client/auth.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            request.setAttribute("erreur", "Cette adresse email est déjà utilisée...");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Client/inscription.jsp");
            dispatcher.forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Client/inscription.jsp");
        dispatcher.forward(request, response);
    }
}
