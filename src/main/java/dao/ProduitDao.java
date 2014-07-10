package dao;

import entity.Produit;
import org.hibernate.SQLQuery;

import java.util.List;

/**
 * Created by nicolas on 15/06/14.
 */
public class ProduitDao extends AbstractDao<Produit, Long> {

    public List<Produit> getAll()
    {
        return this.list(Produit.class);
    }

    public Produit getOne(Produit produit)
    {
        return this.get(Produit.class, produit.getProdId());
    }

    public List<Produit> getProduitsLesPlusVendus(int nbProduits)
    {
        String requete = "SELECT LICMD_PROD_ID FROM LIGNE_COMMANDE INNER JOIN PRODUIT ON PRODUIT.PROD_ID = LIGNE_COMMANDE.LICMD_PROD_ID WHERE ROWNUM <= 3  GROUP BY LICMD_PROD_ID ORDER BY SUM(LICMD_QUANTITE) DESC";
        SQLQuery query = session.createSQLQuery ( requete );
        List<Produit> produits = query.list();
        return produits;
    }

    public List<Produit> getResultSearch(String search)
    {
        String req = "SELECT * FROM produit WHERE UPPER(prod_nom) LIKE UPPER('%'" + search + "'%')";
        SQLQuery query = session.createSQLQuery ( req );
        List<Produit> produits = query.list();
        return produits;
    }
}
