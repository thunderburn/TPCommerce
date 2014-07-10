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
 * Created by nicolas on 16/06/14.
 */
public class VendeurServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("action") == null)
        {
            VendeurDao vendeurDao = new VendeurDao ();
            request.setAttribute ("vendeurs", vendeurDao.getAll());
            request.setAttribute ("notes", vendeurDao.getMoyenne());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Vendeur/vendeur.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            String action = request.getParameter("action").toString();
            switch (action)
            {
                case "infoVendeur":
                    Vendeur vendeur = new Vendeur();
                    vendeur.setVendId(Long.valueOf(request.getParameter("id")));
                    VendeurDao vendeurDao = new VendeurDao();
                    request.setAttribute("vendeur", vendeurDao.getOne(vendeur));
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Vendeur/infoVendeur.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "inscriptionVendeur":
                    RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Vendeur/inscriptionVendeur.jsp");
                    dispatcher1.forward(request, response);
                case "suppressionVendeur":
                    Vendeur vendeur1 = new Vendeur();
                    vendeur1.setVendId(Long.valueOf(request.getParameter("id")));
                    VendeurDao vendeurDao1 = new VendeurDao();
                    request.setAttribute("vendeur", vendeurDao1.getOne(vendeur1));
                    RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Vendeur/suppressionVendeur.jsp");
                    dispatcher2.forward(request, response);

            }
        }


    }
}
