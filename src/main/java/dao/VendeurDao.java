/**
 * Created by valentindufermont on 16/06/2014.
 */
package dao;

import entity.Notevendeur;
import entity.Produit;
import entity.Vend;
import entity.Vendeur;
import org.hibernate.SQLQuery;

import java.util.List;

public class VendeurDao extends AbstractDao<Vendeur, Long> {
	public static void main (String[] args) {
		VendeurDao vendeurDao = new VendeurDao();
		//Vendeur vendeur = new Vendeur();

		System.out.println (vendeurDao.getAll().get(1).getVendNom());
        System.out.println(vendeurDao.getMoyenne());
        //System.out.println (vendeurDao.getOne(vendeur).getVendNote());
	}

	public VendeurDao()
	{
		super();
	}

	public List<Vendeur> getAll()
	{
		return this.list(Vendeur.class);
	}

	public Vendeur getOne(Vendeur vendeur)
	{
		return this.get(Vendeur.class, vendeur.getVendId());
	}

	public List<Notevendeur> getMoyenne()
	{
        // SELECT CAST(vendeur.vend_nom) AS vendeur
        String sql = "SELECT SUM(notevendeur.note_valeur)/COUNT(notevendeur.note_id) AS note FROM vendeur INNER JOIN notevendeur ON vendeur.VEND_ID = notevendeur.VENDEUR_VEND_ID GROUP BY vendeur.vend_nom";
        SQLQuery query = session.createSQLQuery ( sql );
        //squery.setResultTransformer( Criteria.ALIAS_TO_ENTITY_MAP);
        List<Notevendeur> results = query.list();
        return results;
	}

    public void ajouterVendeur(String nom)
    {
        String sql = "INSERT INTO vendeur(vend_id, vend_nom) VALUES (seq_vendeur.NEXTVAL(),'"+ nom +"')";
        SQLQuery query = session.createSQLQuery ( sql );
        //squery.setResultTransformer( Criteria.ALIAS_TO_ENTITY_MAP);
    }


}