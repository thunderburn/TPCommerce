package dao;

import entity.Client;

import java.util.List;

/**
 * Created by nicolas on 04/06/14.
 */
public class ClientDao extends AbstractDao<Client, Long> {
    public static void main(String[] args) {
        ProduitDao produitDao = new ProduitDao();

        //System.out.print(produitDao.getAll().get(0).getVendeurs().get(0).getVendPrix());
    }

    public ClientDao()
    {
        super();
    }

    public List<Client> getAll()
    {
        return this.list(Client.class);
    }

    public Client getOne(Client client)
    {
        return this.get(Client.class, client.getCliId());
    }

    public Client authentification(Client clientAuth){

        String hql = "FROM Client WHERE cliMail ='"+clientAuth.getCliMail()+"' AND cliMotdepasse = '"+clientAuth.getCliMotdepasse()+"'";
        Client result = (Client) session.createQuery(hql).uniqueResult();
        if(result != null)
        {
           return result;
        }
        else
        {
            return null;
        }
    }

    public boolean verifieSiUnMailExisteDeja(String mail)
    {
        String requete = "FROM Client WHERE cliMail = '"+mail+"'";
        List<Client> result = (List<Client>) session.createQuery(requete).list();
        if(result.size() > 0)
            return false;
        else
            return true;
    }


}
