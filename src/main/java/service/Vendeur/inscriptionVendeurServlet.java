package service.Vendeur;

import dao.VendeurDao;
import entity.Vendeur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by valentindufermont on 17/06/2014.
 */
public class inscriptionVendeurServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendeurDao vendeurDao = new VendeurDao();
        Vendeur vendeur = new Vendeur();

        vendeur.setVendNom(request.getParameter("nom"));

        vendeurDao.save(vendeur);
        request.setAttribute("success", "Le vendeur a bien été crée...");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Vendeur/inscriptionVendeur.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Vendeur/inscriptionVendeur.jsp");
        dispatcher.forward(request, response);
    }
}
