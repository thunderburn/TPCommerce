package service.Produit;

import dao.ProduitDao;
import entity.Produit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by nicolas on 16/06/14.
 */
public class ProduitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              executer(request,response);
    }

    private void executer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String page ="/WEB-INF/jsp/Produit/produit.jsp";
        RequestDispatcher dispatcher;

        String action;
        if (request.getParameter("action")==null)
        {
            ProduitDao produitDao = new ProduitDao();
            request.setAttribute("produits", produitDao.getAll());
            action="";
        }
        else
        {
            action = request.getParameter("action");
            switch (action){
                case "infoProduit":
                    page = "/WEB-INF/jsp/Produit/voirProduit.jsp";
                    Produit prod = new Produit();
                    prod.setProdId(Long.valueOf(request.getParameter("id")));
                    ProduitDao produitDao = new ProduitDao();
                    request.setAttribute("produit",produitDao.getOne(prod));
                    break;

                case "searchProduit":
                    page = "/WEB-INF/jsp/Produit/produit.jsp";
                    String result = request.getParameter("search");
                    ProduitDao produitDao1 = new ProduitDao();
                    List<Produit> produitSearch = produitDao1.getResultSearch(result);
                    request.setAttribute("search",produitSearch);
                    break;

                default:
                    page = "/WEB-INF/jsp/Produit/produit.jsp";
                    break;
            }


        }

        dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      executer(request, response);
    }
}
