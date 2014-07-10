package service.Commande;

import dao.CommandeDao;
import entity.Commande;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nicolas on 16/06/14.
 */

public class CommandeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Commande commande = new Commande();
        commande.setCommandeId(Long.valueOf(request.getParameter("id")));
        CommandeDao commandeDao = new CommandeDao();
        System.out.println(commandeDao.getOne(commande).getCommandeNumero());
        commande = commandeDao.getOne(commande);
        request.setAttribute("commande", commande);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/uneCommande.jsp");
        dispatcher.forward(request, response);
    }
}
